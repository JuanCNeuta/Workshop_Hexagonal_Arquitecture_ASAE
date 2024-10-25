package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso.GestionarEspacioCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarEspacioCUAdapter crearGestionarEspacioCUInt(
            GestionarEspacioGatewayIntPort objGestionarEspacioGateway,
            FormateadorResultadosIntPort onjFormateadorResultados) {
        GestionarEspacioCUAdapter objGestionarEspacioCU = new GestionarEspacioCUAdapter(objGestionarEspacioGateway,
                onjFormateadorResultados);
        return objGestionarEspacioCU;
    }
}
