package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjaDTOPeticion {
    private Integer idFranja;
    private String dia;
    private Time horaInicio;
    private Time horaFin;
}
