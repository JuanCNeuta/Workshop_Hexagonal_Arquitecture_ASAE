package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios;

import java.sql.Time;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaRepositoryInt extends CrudRepository<FranjaHorariaEntity, Integer> {
        @Query("SELECT COUNT(f) > 0 " +
                        "FROM FranjaHorariaEntity f " +
                        "JOIN f.objEspacioFisico e " +
                        "WHERE e.idEspacioFisico = :espacioId " +
                        "AND f.dia = :dia " +
                        "AND ((:horaInicio < f.horaFin AND :horaFin > f.horaInicio) " +
                        "     OR (:horaInicio = f.horaInicio AND :horaFin = f.horaFin))")
        Boolean verificarOcupacion(@Param("dia") String dia,
                        @Param("horaInicio") Time horaInicio,
                        @Param("horaFin") Time horaFin,
                        @Param("espacioId") Integer espacioId);

        @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END " +
                        "FROM franja_horaria f " +
                        "JOIN curso c ON c.id_curso = f.curso_id " +
                        "JOIN curso_docente cd ON cd.curso_id = c.id_curso " +
                        "WHERE f.dia = :dia " +
                        "AND f.hora_inicio <= :horaFin " +
                        "AND f.hora_fin >= :horaInicio " +
                        "AND cd.docente_id = :docenteId", nativeQuery = true)
        Boolean verificarOcupacionDocente(@Param("dia") String dia,
                        @Param("horaInicio") Time horaInicio,
                        @Param("horaFin") Time horaFin,
                        @Param("docenteId") Integer docenteId);

}
