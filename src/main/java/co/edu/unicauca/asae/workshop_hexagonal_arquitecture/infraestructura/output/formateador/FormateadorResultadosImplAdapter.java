package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {
    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}
