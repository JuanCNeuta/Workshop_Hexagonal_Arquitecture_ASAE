package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.FranjaDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaMapperInfraestructuraDominio {
    FranjaHoraria mappearDePeticionAFranja(FranjaDTOPeticion peticion);

    FranjaDTORespuesta mappearDeFranjaARespuesta(FranjaHoraria objFranjaHoraria);

    List<FranjaDTORespuesta> mappearDeFranjasARespuesta(List<FranjaDTORespuesta> franjaHoraria);
}
