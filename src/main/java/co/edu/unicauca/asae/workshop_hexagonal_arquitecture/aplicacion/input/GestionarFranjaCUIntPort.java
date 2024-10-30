package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;

public interface GestionarFranjaCUIntPort {
    public FranjaDTORespuesta crear(FranjaHoraria objFranja,Integer cursoId, Integer espacioFisicoId);
    public List<FranjaDTORespuesta> listarPorDocente(Integer docenteId);
}
