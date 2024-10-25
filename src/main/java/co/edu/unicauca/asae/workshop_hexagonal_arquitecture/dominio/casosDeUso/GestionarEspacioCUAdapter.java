package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionEspacioCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;

public class GestionarEspacioCUAdapter implements GestionEspacioCUIntPort {

    private final GestionarEspacioGatewayIntPort objGestionarEspacioGateway;
    
    public GestionarEspacioCUAdapter(GestionarEspacioGatewayIntPort objResgistrarEspacioGateway){
        this.objGestionarEspacioGateway = objResgistrarEspacioGateway;
    }

    @Override
    public List<EspacioFisico> listar() {
        List<EspacioFisico> listaObtenida = objGestionarEspacioGateway.listar();
        return listaObtenida;
    }

}
