package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.Getter;

@Getter
public class EspacioOcupadoException extends RuntimeException {
    private final String llaveMensaje;
    private final String codigo;

    public EspacioOcupadoException(CodigoError code) {
        super(code.getCodigo());
        this.llaveMensaje = code.getLlaveMensaje();
        this.codigo = code.getCodigo();
    }

    public EspacioOcupadoException(final String message) {
        super(message);
        this.llaveMensaje = CodigoError.ESPACIO_OCUPADO.getLlaveMensaje();
        this.codigo = CodigoError.ESPACIO_OCUPADO.getCodigo();
    }
}
