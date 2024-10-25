package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacioDTORespuesta {

    private Integer idEspacioFisico;
    private String nombre;
    private Integer capacidad;
    //private List<FranjaHoraria> franjasHorarias;
    
}
