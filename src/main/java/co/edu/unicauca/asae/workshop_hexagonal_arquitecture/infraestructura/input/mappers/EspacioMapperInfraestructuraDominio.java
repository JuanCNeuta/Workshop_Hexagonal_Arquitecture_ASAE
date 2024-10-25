package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.EspacioDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.EspacioDTORespuesta;

@Mapper(componentModel = "spring")
public interface EspacioMapperInfraestructuraDominio {
    EspacioFisico  mappearDePeticionAEspacio(EspacioDTOPeticion peticion);

    EspacioDTORespuesta mappearDeEspacioARespuesta(EspacioFisico objEspacioFisico);

    List<EspacioDTORespuesta> mappearDeEspaciosARespuesta(List<EspacioFisico> espaciosFisicos);
}
