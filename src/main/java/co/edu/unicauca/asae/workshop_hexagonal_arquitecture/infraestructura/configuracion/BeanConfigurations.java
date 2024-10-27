package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarEspacioGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarFranjaGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso.GestionarEspacioCUAdapter;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso.GestionarFranjaCUAdapter;

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

    @Bean
    public GestionarFranjaCUAdapter crearGestionarFranjaCUInt(
            GestionarFranjaGatewayIntPort objGestionarFranjaGateway,
            FormateadorResultadosIntPort onjFormateadorResultados) {
        GestionarFranjaCUAdapter objGestionarFranjaCU = new GestionarFranjaCUAdapter(objGestionarFranjaGateway,
                onjFormateadorResultados);
        return objGestionarFranjaCU;
    }

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
        GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            FormateadorResultadosIntPort objDocenteformateadorResultados){
                GestionarDocenteCUAdapter objGestionarDocenteCU= new GestionarDocenteCUAdapter(objGestionarDocenteGateway, 
                objDocenteformateadorResultados);
                return objGestionarDocenteCU;         
    }
}
