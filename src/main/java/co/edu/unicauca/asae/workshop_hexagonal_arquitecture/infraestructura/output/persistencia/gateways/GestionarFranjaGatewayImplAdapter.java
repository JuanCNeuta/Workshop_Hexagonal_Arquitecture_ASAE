package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.gateways;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.FranjaRepositoryInt;
import jakarta.transaction.Transactional;

@Service
public class GestionarFranjaGatewayImplAdapter implements GestionarFranjaGatewayIntPort{
    private final FranjaRepositoryInt objFranjaRepository;
    private final ModelMapper franjaModelMapper;
    
    public GestionarFranjaGatewayImplAdapter(FranjaRepositoryInt objFranjaRepository, @Qualifier("franjaModelMapper")ModelMapper franjaModelMapper){
        this.objFranjaRepository = objFranjaRepository;
        this.franjaModelMapper = franjaModelMapper;
    }

    @Override
    public Integer verificarOcupacionDocente(String dia, Time horaInicio, Time horaFin, Integer docenteId) {
        return this.objFranjaRepository.verificarOcupacionDocente(dia, horaInicio,horaFin, docenteId);
    }

    @Override
    public boolean verificarOcupacion(String dia, Time horaInicio, Time horaFin, Integer espacioId) {
        return this.objFranjaRepository.verificarOcupacion(dia, horaInicio,horaFin, espacioId);
    }

    @Override
    public List<Integer> buscarDocentesQueDictanCurso(Integer cursoId) {
        return this.objFranjaRepository.buscarDocentesQueDictanCurso(cursoId);
    }

    @Override
    @Transactional
    public List<FranjaDTORespuesta> listarPorDocente(Integer docenteId) {
        Iterable<FranjaHorariaEntity> lista = objFranjaRepository.listarPorDocente(docenteId);
        List<FranjaDTORespuesta> listaObtenida = new ArrayList<>();

    for(FranjaHorariaEntity franjaEntity : lista){
        FranjaDTORespuesta franjaDominio = franjaModelMapper.map(franjaEntity, FranjaDTORespuesta.class);
        
        // Aquí aseguramos que los nombres del curso y del espacio físico sean trasladados correctamente
        if (franjaEntity.getObjCurso() != null) {
            franjaDominio.setCursoNombre(franjaEntity.getObjCurso().getNombre());
        }
        if (franjaEntity.getObjEspacioFisico() != null) {
            franjaDominio.setEspacioFisicoNombre(franjaEntity.getObjEspacioFisico().getNombre());
        }

        listaObtenida.add(franjaDominio);
    }

    return listaObtenida;
    }

    @Override
    public FranjaHoraria guardar(FranjaHoraria objFranja,Integer cursoId,Integer espacioFisicoId) {
        FranjaHorariaEntity objFranjaEntity = this.franjaModelMapper.map(objFranja, FranjaHorariaEntity.class);

        // Asociar el espacio físico y curso existentes utilizando los IDs proporcionados en la URL
        EspacioFisicoEntity espacioFisico = new EspacioFisicoEntity();
        espacioFisico.setIdEspacioFisico(espacioFisicoId);
        
        CursoEntity curso = new CursoEntity();
        curso.setIdCurso(cursoId);

        // Asignar espacio físico y curso a la franja horaria
        objFranjaEntity.setObjEspacioFisico(espacioFisico);
        objFranjaEntity.setObjCurso(curso);

        FranjaHorariaEntity objFranjaEntityRegistrado = this.objFranjaRepository.save(objFranjaEntity);
        FranjaHoraria objFranjaRespuesta = this.franjaModelMapper.map(objFranjaEntityRegistrado, FranjaHoraria.class);
        return objFranjaRespuesta;
    }

}
