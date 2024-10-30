package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjaDTORespuesta {

    private Integer idFranja;
    private String dia;
    private Time horaInicio;
    private Time horaFin;
    private String cursoNombre;
    private String espacioFisicoNombre;

    public FranjaDTORespuesta(){}
}
