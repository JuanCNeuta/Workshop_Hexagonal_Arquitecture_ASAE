package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Docente extends Persona{
    
    private Oficina objOficina;
    private List<Curso> cursos;

    public Docente(){

    }

}
