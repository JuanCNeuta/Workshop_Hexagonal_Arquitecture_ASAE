package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.controladores;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarFranjaCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.FranjaDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers.FranjaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class FranjaHorariaRestController {
    private final GestionarFranjaCUIntPort objGestionFranjasCUInt;
    private final FranjaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/Franjas/{cursoId}/{espacioFisicoId}")
    public ResponseEntity<FranjaDTORespuesta> create(
            @RequestBody @Valid FranjaDTOPeticion objFranja,
            @PathVariable Integer cursoId,
            @PathVariable Integer espacioFisicoId) {
        System.out.println("Creando Franja Horaria");
        FranjaHoraria objFranjaCrear = objMapeador.mappearDePeticionAFranja(objFranja);
        ResponseEntity<FranjaDTORespuesta> objRespuesta = new ResponseEntity<FranjaDTORespuesta>(
                objMapeador.mappearDeFranjaARespuesta(this.objGestionFranjasCUInt.crear(objFranjaCrear, cursoId, espacioFisicoId)),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/Franjas/docente/{docenteId}")
    public ResponseEntity<List<FranjaDTORespuesta>> listar(
            @PathVariable @Min(value = 1, message = "{docente.id.min}") Integer docenteId) {
        System.out.println("Listando Franjas Horarias del docente con ID: " + docenteId);
        ResponseEntity<List<FranjaDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaDTORespuesta>>(
                objMapeador.mappearDeFranjasARespuesta(this.objGestionFranjasCUInt.listarPorDocente(docenteId)),
                HttpStatus.OK);
        return objRespuesta;
    }
}
