package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.CursoEntity;

public interface CursoRepositoryInt extends CrudRepository<CursoEntity, Integer> {
    
}
