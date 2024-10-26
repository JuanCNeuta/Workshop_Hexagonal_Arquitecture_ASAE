package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

public interface FranjaRepositoryInt extends CrudRepository<FranjaHorariaEntity, Integer>  {
    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END " +
           "FROM FranjaHorariaEntity f JOIN f.espacioFisico e " +
           "WHERE e.id = :espacioId " +
           "AND f.dia = :dia " +
           "AND f.horaInicio <= :horaFin " +
           "AND f.horaFin >= :horaInicio")
    Boolean verificarOcupacion(@Param("dia") String dia,
                               @Param("horaInicio") String horaInicio,
                               @Param("horaFin") String horaFin,
                               @Param("espacioId") Integer espacioId);
}
