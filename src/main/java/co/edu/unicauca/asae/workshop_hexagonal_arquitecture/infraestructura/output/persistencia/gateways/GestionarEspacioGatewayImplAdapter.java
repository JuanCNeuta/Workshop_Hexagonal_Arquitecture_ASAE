package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.gateways;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.EspacioRepositoryInt;

@Service
public class GestionarEspacioGatewayImplAdapter implements GestionarEspacioGatewayIntPort {

    private final EspacioRepositoryInt objEspacioRepository;
    private final ModelMapper espacioModelMapper;
    
    public GestionarEspacioGatewayImplAdapter(EspacioRepositoryInt objEspacioRepository, ModelMapper espacioModelMapper){
        this.objEspacioRepository = objEspacioRepository;
        this.espacioModelMapper = espacioModelMapper;
    }
    @Override
    public boolean existeEspacioPorNombre(String nombre) {
        return this.objEspacioRepository.existeEspacioPorNombre(nombre) == 1;
    }

    @Override
    public List<EspacioFisico> listar(String patron, int capacidad) {
        // Obtiene la lista de EspacioFisicoEntity que cumple con los criterios
        Iterable<EspacioFisicoEntity> lista = objEspacioRepository.listar(patron, capacidad);
        List<EspacioFisico> listaObtenida = this.espacioModelMapper.map(lista, new TypeToken<List<EspacioFisico>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public EspacioFisico guardar(EspacioFisico objEspacio) {
        EspacioFisicoEntity objEspacioEntity = this.espacioModelMapper.map(objEspacio, EspacioFisicoEntity.class);
        EspacioFisicoEntity objEspacioEntityRegistrado = this.objEspacioRepository.save(objEspacioEntity);
        EspacioFisico objEspacioRespuesta = this.espacioModelMapper.map(objEspacioEntityRegistrado, EspacioFisico.class);
        return objEspacioRespuesta;
    }
}
