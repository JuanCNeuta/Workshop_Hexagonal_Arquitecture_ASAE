package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionEspacioCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;

public class GestionarEspacioCUAdapter implements GestionEspacioCUIntPort {

    private final GestionarEspacioGatewayIntPort objGestionarEspacioGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    
    public GestionarEspacioCUAdapter(GestionarEspacioGatewayIntPort objResgistrarEspacioGateway,
            FormateadorResultadosIntPort objFormateadorResultados){
        this.objGestionarEspacioGateway = objResgistrarEspacioGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public EspacioFisico crear(EspacioFisico objEspacio) {
        EspacioFisico objEspacioCreado = null;
        if (this.objGestionarEspacioGateway.existeEspacioPorNombre(objEspacio.getNombre())) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un espacio con ese nombre");
        } else {
            objEspacioCreado = this.objGestionarEspacioGateway.guardar(objEspacio);
        }
        return objEspacioCreado;
    }

    @Override
    public List<EspacioFisico> listar(String patron, int capacidad) {
        return objGestionarEspacioGateway.listar(patron, capacidad);
    }

}
