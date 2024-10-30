package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion;

import java.sql.Time;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjaDTOPeticion {
    @NotNull(message = "{franja.dia.emply}")
    @Size(min = 3, max = 15, message = "{franja.dia.size}")
    @Pattern(regexp = "^(Lunes|Martes|Miercoles|Jueves|Viernes|Sabado|Domingo)$",
             message = "{franja.dia.pattern}")
    private String dia;

    @NotNull(message = "{franja.horainicio.emply}")
    private Time horaInicio;

    @NotNull(message = "{franja.horafin.emply}")
    private Time horaFin;
}
