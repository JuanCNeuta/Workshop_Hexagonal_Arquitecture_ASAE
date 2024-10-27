package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mappearDePeticionADocente(DocenteDTOPeticion objDocente);
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente objDocente);
}
