package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaCUIntPort {
    public FranjaHoraria crear(FranjaHoraria objFranja,Integer cursoId, Integer espacioFisicoId);
    public List<FranjaHoraria> listar();
}
