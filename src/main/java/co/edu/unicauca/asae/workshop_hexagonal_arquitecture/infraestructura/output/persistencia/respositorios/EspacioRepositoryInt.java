package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

public interface EspacioRepositoryInt extends CrudRepository<EspacioFisicoEntity, Integer> {
    @Query("SELECT count(*) FROM EspacioFisicoEntity p WHERE p.nombre = ?1")
    Integer existeEspacioPorNombre(String nombre);
}
