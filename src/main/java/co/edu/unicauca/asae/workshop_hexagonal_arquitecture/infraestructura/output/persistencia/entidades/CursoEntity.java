package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "asignatura_id", referencedColumnName = "idAsignatura")
    private AsignaturaEntity objAsignatura;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objCurso", cascade = CascadeType.REMOVE)
    private List<FranjaHorariaEntity> franjasHorarias;

    //Relacion muchos a muchos bidireccional con docente
    @ManyToMany(mappedBy = "cursos") 
    private List<DocenteEntity> docentes;

    public CursoEntity(String nombre){
        this.nombre=nombre;
    }
}
