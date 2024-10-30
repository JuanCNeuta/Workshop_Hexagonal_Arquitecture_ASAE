package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

import java.sql.Time;
import java.util.List;


import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;

public interface GestionarFranjaGatewayIntPort {
    public boolean verificarOcupacion(String dia, Time horaInicio, Time horaFin, Integer espacioId);

    public FranjaDTORespuesta guardar(FranjaHoraria objEspacio,Integer cursoId,Integer espacioFisicoId);

    public List<FranjaDTORespuesta> listarPorDocente(Integer docenteId);

    public Integer verificarOcupacionDocente(String dia, Time horaInicio, Time horaFin, Integer docenteId);

    public List<Integer> buscarDocentesQueDictanCurso(Integer cursoId);
}
