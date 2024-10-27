package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Docente")
@PrimaryKeyJoinColumn(name = "persona_id") // une con la tabla Persona
public class DocenteEntity extends PersonaEntity{
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "oficina_id", referencedColumnName = "idOficina")
    @JsonIgnore
    private OficinaEntity objOficina;

    @ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(name = "Curso_Docente",
    joinColumns = @JoinColumn(name = "docente_id"),
    inverseJoinColumns = @JoinColumn(name="curso_id"))
    List<CursoEntity> cursos;

    public DocenteEntity(){
        super();
    }

    public DocenteEntity(String nombrePersona, String apellidoPersona, String correoPersona){
        super(nombrePersona, apellidoPersona, correoPersona);
    }

    public void agregarCurso(CursoEntity curso){
        this.cursos.add(curso);
    }
}
