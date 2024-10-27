package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input;

import java.sql.Time;
import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaCUIntPort {
    public FranjaHoraria crear(FranjaHoraria objFranja, String dia, Time horaInicio, Time horaFin, Integer espacioId);
    public List<FranjaHoraria> listar();
}
