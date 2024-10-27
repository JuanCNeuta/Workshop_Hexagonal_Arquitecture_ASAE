package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FranjaHoraria {
    
    private Integer idFranja;
    private String dia;
    private Time horaInicio;
    private Time horaFin;
}
