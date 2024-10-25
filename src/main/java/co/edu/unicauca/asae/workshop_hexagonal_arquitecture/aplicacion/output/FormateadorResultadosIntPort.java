package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

public interface FormateadorResultadosIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}