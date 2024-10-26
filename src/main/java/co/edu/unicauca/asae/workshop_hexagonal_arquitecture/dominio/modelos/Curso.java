package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Curso {
    private Integer idCurso;
    private String nombre;
}
