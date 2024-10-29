package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarFranjaCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;

public class GestionarFranjaCUAdapter implements GestionarFranjaCUIntPort {

    private final GestionarFranjaGatewayIntPort objGestionarFranjaGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    
    public GestionarFranjaCUAdapter(GestionarFranjaGatewayIntPort objResgistrarFranjaGateway,
            FormateadorResultadosIntPort objFormateadorResultados){
        this.objGestionarFranjaGateway = objResgistrarFranjaGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public FranjaHoraria crear(FranjaHoraria objFranja,Integer cursoId, Integer espacioFisicoId) {
        FranjaHoraria objFranjaCreado = null;

        // Verificamos si el espacio está ocupado
        boolean estaOcupado = this.objGestionarFranjaGateway.verificarOcupacion(
                objFranja.getDia(), objFranja.getHoraInicio(), objFranja.getHoraFin(), espacioFisicoId);

        System.out.println("¿Espacio ocupado?: " + estaOcupado);

        // Si está ocupado, lanzamos el error
        if (estaOcupado){
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, El espacio físico " + //
                                                "está ocupado en el di\u00E1, hora de inicio y hora fin.");
        } else if (!this.objGestionarFranjaGateway.verificarOcupacionDocente(objFranja.getDia(), objFranja.getHoraInicio(), objFranja.getHoraFin(), espacioFisicoId)) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, El docente\r\n" + //
                                                "se encuentra ocupado en el di\\u00E1, hora de inicio y hora fin.");
        } else {
            objFranjaCreado = this.objGestionarFranjaGateway.guardar(objFranja,cursoId,espacioFisicoId);
        }
        return objFranjaCreado;
    }

    @Override
    public List<FranjaHoraria> listar() {
        return objGestionarFranjaGateway.listar();
    }
}
