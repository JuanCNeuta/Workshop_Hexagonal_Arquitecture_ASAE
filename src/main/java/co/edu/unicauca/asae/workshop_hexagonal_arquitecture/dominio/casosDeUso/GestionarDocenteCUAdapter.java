package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.casosDeUso;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{

    private final GestionarDocenteGatewayIntPort objGestionarProductoGateway;
    private final FormateadorResultadosIntPort objDocenteFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarProductoGateway,
    FormateadorResultadosIntPort objDocenteFormateadorResultados){
        this.objGestionarProductoGateway=objGestionarProductoGateway;
        this.objDocenteFormateadorResultados=objDocenteFormateadorResultados;
    }

    @Override
    public Docente crearDocente(Docente objDocente) {
        Docente objDocenteCreado= null;
        if(this.objGestionarProductoGateway.existeDocentePorCorreo(objDocente.getCorreoPersona())){
            this.objDocenteFormateadorResultados
                .retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un Docente con el correo ingresado");
        }else{
            objDocenteCreado= this.objGestionarProductoGateway.guardarDocente(objDocente);
        }
        return objDocenteCreado;
    }
    
}
