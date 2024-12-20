package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarFranjaCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;

public class GestionarFranjaCUAdapter implements GestionarFranjaCUIntPort {

    private final GestionarFranjaGatewayIntPort objGestionarFranjaGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarFranjaCUAdapter(GestionarFranjaGatewayIntPort objResgistrarFranjaGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarFranjaGateway = objResgistrarFranjaGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public FranjaDTORespuesta crear(FranjaHoraria objFranja, Integer cursoId, Integer espacioFisicoId) {
        FranjaDTORespuesta objFranjaCreado = null;

        boolean estaOcupado = this.objGestionarFranjaGateway.verificarOcupacion(
                objFranja.getDia(), objFranja.getHoraInicio(), objFranja.getHoraFin(), espacioFisicoId);

        if (estaOcupado) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEspacioOcupado(
                            "Error, El espacio físico está ocupado en el día, hora de inicio y hora fin.");
        } else {
            List<Integer> docentesCurso = this.objGestionarFranjaGateway.buscarDocentesQueDictanCurso(cursoId);

            if (docentesCurso.isEmpty()) {
                docentesCurso.add(0);
            }

            Map<Integer, Boolean> docentesOcupados = new HashMap<>();
         
            for (Integer docenteId : docentesCurso) {
                Integer docenteOcupado = this.objGestionarFranjaGateway.verificarOcupacionDocente(
                        objFranja.getDia(), objFranja.getHoraInicio(), objFranja.getHoraFin(), docenteId);

                if (docenteOcupado>0) {
                    docentesOcupados.put(docenteId, true);
                }
            }

            if (!docentesOcupados.isEmpty()) {
                this.objFormateadorResultados.retornarRespuestaErrorDocentesOcupados(docentesOcupados.keySet());
                return null;
            }
            
            objFranjaCreado = this.objGestionarFranjaGateway.guardar(objFranja, cursoId, espacioFisicoId);
        }

        return objFranjaCreado;
    }

    @Override
    public List<FranjaDTORespuesta> listarPorDocente(Integer docenteId) {
        return objGestionarFranjaGateway.listarPorDocente(docenteId);
    }
}
