package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FranjaMapper {
    @Bean
    public ModelMapper crearFranjaMapper(){
        return new ModelMapper();
    }
}
