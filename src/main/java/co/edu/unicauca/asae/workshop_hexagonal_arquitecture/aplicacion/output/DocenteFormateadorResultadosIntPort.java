package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;

public interface DocenteFormateadorResultadosIntPort {
    public Docente prepararRespuestaFallida(String error);
}
