package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import java.sql.Time;
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
    public FranjaHoraria crear(FranjaHoraria objFranja, String dia, Time horaInicio, Time horaFin, Integer espacioId) {
        FranjaHoraria objFranjaCreado = null;
        if (!this.objGestionarFranjaGateway.verificarOcupacion(dia, horaInicio, horaFin, espacioId)) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, El espacio físico\r\n" + //
                                                "está ocupado en el día, hora de inicio y hora fin.");
        } else {
            objFranjaCreado = this.objGestionarFranjaGateway.guardar(objFranja);
        }
        return objFranjaCreado;
    }

    @Override
    public List<FranjaHoraria> listar() {
        return objGestionarFranjaGateway.listar();
    }
}
