package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EspacioFisico {
    
    private Integer idEspacioFisico;
    private String nombre;
    private Integer capacidad;
    //private List<FranjaHoraria> franjasHorarias;

    public EspacioFisico(){

    }

}
