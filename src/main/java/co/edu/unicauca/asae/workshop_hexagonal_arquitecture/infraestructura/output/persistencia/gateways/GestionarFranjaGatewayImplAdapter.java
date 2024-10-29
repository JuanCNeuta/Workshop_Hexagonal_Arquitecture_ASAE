package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.gateways;

import java.sql.Time;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Curso;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.EspacioRepositoryInt;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.FranjaRepositoryInt;

@Service
public class GestionarFranjaGatewayImplAdapter implements GestionarFranjaGatewayIntPort{
    private final FranjaRepositoryInt objFranjaRepository;
    private final ModelMapper franjaModelMapper;
    
    public GestionarFranjaGatewayImplAdapter(FranjaRepositoryInt objFranjaRepository, @Qualifier("franjaModelMapper")ModelMapper franjaModelMapper){
        this.objFranjaRepository = objFranjaRepository;
        this.franjaModelMapper = franjaModelMapper;
    }

   /* */ @Override
    public boolean verificarOcupacion(String dia, Time horaInicio, Time horaFin, Integer espacioId) {
        //return this.objFranjaRepository.verificarOcupacion(dia, horaInicio,horaFin, espacioId);
        return false;
    }

    @Override
    public List<FranjaHoraria> listar() {
        // Obtiene la lista de EspacioFisicoEntity que cumple con los criterios
        //Iterable<FranjaHorariaEntity> lista = objFranjaRepository.findAll();
        //List<FranjaHoraria> listaObtenida = this.franjaModelMapper.map(lista, new TypeToken<List<FranjaHoraria>>() {
        //}.getType());
        //return listaObtenida;
        return null;
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
