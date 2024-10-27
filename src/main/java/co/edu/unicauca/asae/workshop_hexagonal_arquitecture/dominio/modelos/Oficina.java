package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Oficina {
    private Integer idOficina; 
    private String nombre;
    private String ubicacion;
	private Docente objDocente;

    public Oficina(){
        
    }
}
