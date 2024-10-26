package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    @Column(length = 50)
    private String nombrePersona;

    @Column(length = 50)
    private String apellidoPersona;

    @Column(length = 50 , unique = true)
    private String correoPersona;

    public PersonaEntity(String nombrePersona,String apellidoPersona,String correoPersona){
        this.nombrePersona=nombrePersona;
        this.apellidoPersona=apellidoPersona;
        this.correoPersona=correoPersona;
    }
}
