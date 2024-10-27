package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Oficina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORespuesta {
    //Atributos persona
    private Integer idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String correoPersona;

    //Atributos Docente
    private Oficina objOficina;
    //private List<Curso> cursos;

    public DocenteDTORespuesta(){

    }
}
