package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

public interface EspacioRepositoryInt extends CrudRepository<EspacioFisicoEntity, Integer> {

    @Query("SELECT p FROM EspacioFisicoEntity p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT(:patron, '%')) AND p.capacidad >= :capacidad ORDER BY p.nombre ASC")
    Iterable<EspacioFisicoEntity> listar(@Param("patron") String patron, @Param("capacidad") Integer capacidad);

    @Query("SELECT count(*) FROM EspacioFisicoEntity p WHERE p.nombre = ?1")
    Integer existeEspacioPorNombre(String nombre);
}
