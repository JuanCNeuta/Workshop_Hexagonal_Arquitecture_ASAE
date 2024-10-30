package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

import java.util.Collection;

public interface FormateadorResultadosIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
    public void retornarRespuestaErrorDocentesOcupados(Collection<Integer> idsOcupados);
}