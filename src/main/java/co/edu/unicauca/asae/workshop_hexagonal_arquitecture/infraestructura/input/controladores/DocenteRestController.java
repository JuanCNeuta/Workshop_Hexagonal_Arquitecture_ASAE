package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Docente;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocentesCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> create(@RequestBody @Valid DocenteDTOPeticion objDocente) {
        System.out.println("Creando un Docente");
        Docente objDocenteCrear = objMapeador.mappearDePeticionADocente(objDocente);
        Docente objDocenteCreado = objGestionarDocentesCUInt.crearDocente(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(objDocenteCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

}
