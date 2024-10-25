package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EspacioMapper {
    @Bean
    public ModelMapper crearEspacioMapper(){
        return new ModelMapper();
    }
    
}
