package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarFranjaCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;

public class GestionarFranjaCUAdapter implements GestionarFranjaCUIntPort {

    private final GestionarFranjaGatewayIntPort objGestionarFranjaGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarFranjaCUAdapter(GestionarFranjaGatewayIntPort objResgistrarFranjaGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarFranjaGateway = objResgistrarFranjaGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public FranjaHoraria crear(FranjaHoraria objFranja, Integer cursoId, Integer espacioFisicoId) {
        FranjaHoraria objFranjaCreado = null;

        boolean estaOcupado = this.objGestionarFranjaGateway.verificarOcupacion(
                objFranja.getDia(), objFranja.getHoraInicio(), objFranja.getHoraFin(), espacioFisicoId);

        if (estaOcupado) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste(
                            "Error, El espacio físico está ocupado en el día, hora de inicio y hora fin.");
        } else {
            List<Integer> docentesCurso = this.objGestionarFranjaGateway.buscarDocentesQueDictanCurso(cursoId);
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
    public List<FranjaHoraria> listar() {
        return objGestionarFranjaGateway.listar();
    }
}
