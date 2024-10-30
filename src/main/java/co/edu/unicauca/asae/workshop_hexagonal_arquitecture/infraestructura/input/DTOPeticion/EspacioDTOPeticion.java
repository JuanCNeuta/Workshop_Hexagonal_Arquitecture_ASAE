package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacioDTOPeticion {
    @NotNull(message = "{espacio.nombre.emply}")
    @Size(min = 5, max = 45, message = "{espacio.nombre.size}")
    private String nombre;

    @NotNull(message = "{espacio.capacidad.emply}")
    @Positive(message = "{espacio.capacidad.positive}")
    private Integer capacidad;
    // private List<FranjaHoraria> franjasHorarias;

}
