package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.gateways;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.OficinaEntity;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.respositorios.DocenteRepositoryInt;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepositoryInt objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository,
            @Qualifier("docenteModelMapper") ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;

    }

    @Override
    public boolean existeDocentePorCorreo(String correo) {
        return this.objDocenteRepository.existeDocentePorCorreo(correo) == 1;
    }

    @Override
    public Docente guardarDocente(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        // Relación bidireccional configuracion
        OficinaEntity oficinaEntity = objDocenteEntity.getObjOficina();
        if (oficinaEntity != null) {
            oficinaEntity.setObjDocente(objDocenteEntity); // Sincroniza la relación bidireccional
        }
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

}
