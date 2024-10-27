package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.gateways;

import java.sql.Time;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.EspacioRepositoryInt;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.FranjaRepositoryInt;

@Service
public class GestionarFranjaGatewayImplAdapter implements GestionarFranjaGatewayIntPort{
    private final FranjaRepositoryInt objFranjaRepository;
    private final ModelMapper franjaModelMapper;
    
    public GestionarFranjaGatewayImplAdapter(FranjaRepositoryInt objFranjaRepository, ModelMapper franjaModelMapper){
        this.objFranjaRepository = objFranjaRepository;
        this.franjaModelMapper = franjaModelMapper;
    }

    @Override
    public boolean verificarOcupacion(String dia, Time horaInicio, Time horaFin, Integer espacioId) {
        return this.objFranjaRepository.verificarOcupacion(dia, horaInicio,horaFin, espacioId);
    }

    @Override
    public List<FranjaHoraria> listar() {
        // Obtiene la lista de EspacioFisicoEntity que cumple con los criterios
        Iterable<FranjaHorariaEntity> lista = objFranjaRepository.findAll();
        List<FranjaHoraria> listaObtenida = this.franjaModelMapper.map(lista, new TypeToken<List<FranjaHoraria>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public FranjaHoraria guardar(FranjaHoraria objFranja) {
        FranjaHorariaEntity objFranjaEntity = this.franjaModelMapper.map(objFranja, FranjaHorariaEntity.class);
        FranjaHorariaEntity objFranjaEntityRegistrado = this.objFranjaRepository.save(objFranjaEntity);
        FranjaHoraria objFranjaRespuesta = this.franjaModelMapper.map(objFranjaEntityRegistrado, FranjaHoraria.class);
        return objFranjaRespuesta;
    }
}
