package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {

    public boolean existeDocentePorCorreo(String correo);
    
    public Docente guardarDocente(Docente objDocente);
}
