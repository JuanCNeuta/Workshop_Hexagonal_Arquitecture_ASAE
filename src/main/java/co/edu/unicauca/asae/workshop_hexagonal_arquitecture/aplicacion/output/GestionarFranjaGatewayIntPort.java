package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

import java.sql.Time;
import java.util.List;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaGatewayIntPort {
    public boolean verificarOcupacion(String dia, Time horaInicio, Time horaFin, Integer espacioId);

    public FranjaHoraria guardar(FranjaHoraria objEspacio,Integer cursoId,Integer espacioFisicoId);

    public List<FranjaHoraria> listar();
}
