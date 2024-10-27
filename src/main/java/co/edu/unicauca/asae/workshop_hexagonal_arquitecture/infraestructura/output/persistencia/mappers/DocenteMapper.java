package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Oficina;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.entidades.OficinaEntity;

@Configuration
public class DocenteMapper {
    @Bean (name = "docenteModelMapper")
    public ModelMapper crearDocentMapper(){
        ModelMapper objMapper = new ModelMapper();
        //TypeMap<DocenteEntity,Docente> mapa=objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
       // mapa.addMappings(m->m.skip(Docente::setObjOficina)).implicitMappings();
        TypeMap<OficinaEntity,Oficina> mapa=objMapper.emptyTypeMap(OficinaEntity.class, Oficina.class);
        mapa.addMappings(m->m.skip(Oficina::setObjDocente)).implicitMappings();
        return objMapper;
    }
    
}
