package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;

public interface GestionarEspacioGatewayIntPort {
    public List<EspacioFisico> listar();
}
