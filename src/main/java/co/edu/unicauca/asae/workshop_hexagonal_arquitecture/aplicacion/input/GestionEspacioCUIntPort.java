package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;

public interface GestionEspacioCUIntPort {

    public EspacioFisico crear(EspacioFisico objEspacio);
    public List<EspacioFisico> listar(String patron, int capacidad);
    
}
