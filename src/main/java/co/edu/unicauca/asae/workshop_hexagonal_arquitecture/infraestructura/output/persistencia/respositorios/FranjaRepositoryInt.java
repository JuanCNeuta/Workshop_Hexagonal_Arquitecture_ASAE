package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface FranjaRepositoryInt extends CrudRepository<FranjaHorariaEntity, Integer> {

        // Metodo para verificar la disponibilidad de una franja
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

        // Metodo para verificar la disponibilidad del docente
        @Query(value = "SELECT COUNT(*) > 0 " +
                        "FROM franja_horaria f " +
                        "JOIN curso c ON c.idCurso = f.curso_id " +
                        "JOIN curso_docente cd ON cd.curso_id = c.idCurso " +
                        "WHERE f.dia = :dia " +
                        "AND ((:horaInicio < f.hora_fin AND :horaFin > f.hora_inicio) " +
                        "     OR (:horaInicio = f.hora_inicio AND :horaFin = f.hora_fin)) " +
                        "AND cd.docente_id = :docenteId", nativeQuery = true)
        Integer verificarOcupacionDocente(@Param("dia") String dia,
                        @Param("horaInicio") Time horaInicio,
                        @Param("horaFin") Time horaFin,
                        @Param("docenteId") Integer docenteId);

        // Metodo para traer el listado de docentes que dictan un curso
        @Query(value = "SELECT cd.docente_id FROM curso AS c JOIN curso_docente AS cd " +
                        " on cd.curso_id=c.idCurso where cd.curso_id=:curso_id", nativeQuery = true)
        List<Integer> buscarDocentesQueDictanCurso(@Param("curso_id") Integer curso_id);

        @Query("SELECT f FROM FranjaHorariaEntity f " +
                        "JOIN f.objCurso c " +
                        "JOIN c.docentes d " +
                        "WHERE d.id = :docenteId")
        Iterable<FranjaHorariaEntity> listarPorDocente(@Param("docenteId") Integer docenteId);

}
