package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacioDTOPeticion {
    private Integer idEspacioFisico;
    private String nombre;
    private Integer capacidad;
    //private List<FranjaHoraria> franjasHorarias;

}
