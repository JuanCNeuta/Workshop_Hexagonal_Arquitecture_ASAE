package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
   
    private Integer idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String correoPersona;

    public Persona(){

    }
    
}
