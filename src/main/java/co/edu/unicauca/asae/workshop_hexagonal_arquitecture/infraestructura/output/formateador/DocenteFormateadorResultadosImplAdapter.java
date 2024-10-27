package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.formateador;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.DocenteFormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;

@Service
public class DocenteFormateadorResultadosImplAdapter implements DocenteFormateadorResultadosIntPort{

    @Override
    public Docente prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
    
}
