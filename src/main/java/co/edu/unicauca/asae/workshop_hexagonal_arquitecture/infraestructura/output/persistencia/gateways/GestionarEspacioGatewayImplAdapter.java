package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.gateways;

import java.util.List;

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
    public List<EspacioFisico> listar() {
        Iterable<EspacioFisicoEntity> lista = this.objEspacioRepository.findAll();
        List<EspacioFisico> listaObtenida = this.espacioModelMapper.map(lista, new TypeToken<List<EspacioFisico>>() {
        }.getType());
        return listaObtenida;
    }
}
