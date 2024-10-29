package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Oficina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion {
    
    //Atributos persona
    //private Integer idPersona;
    @NotNull(message = "{docente.nombre.emply}")
    @Size(min = 5, max = 45, message = "{docente.nombre.size}")
    private String nombrePersona;

    @NotNull(message = "{docente.apellido.emply}")
    @Size(min = 5, max = 45 , message = "{docente.apellido.size}")
    private String apellidoPersona;

    @NotNull(message = "{docente.email.empty}")
    @Email(message = "{docente.email.invalid}")
    private String correoPersona;

    //Atributos Docente
    private Oficina objOficina;
    //private List<Curso> cursos;
}
