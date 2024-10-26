package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "Administrativo")
@PrimaryKeyJoinColumn(name = "persona_id")
public class AdministrativoEntity extends PersonaEntity{
    
    @Column(length = 255)
    private String rol;
}
