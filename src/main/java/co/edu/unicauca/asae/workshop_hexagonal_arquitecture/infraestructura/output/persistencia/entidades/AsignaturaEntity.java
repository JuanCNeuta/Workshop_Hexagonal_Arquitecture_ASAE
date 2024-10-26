package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Asignatura")
public class AsignaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignatura;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "codigo", nullable = false, length = 50, unique = true)
    private String codigo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objAsignatura")
    private List<CursoEntity> cursos;

    public AsignaturaEntity(String nombre,String codigo){
        this.nombre=nombre;
        this.codigo=codigo;
    }
}
