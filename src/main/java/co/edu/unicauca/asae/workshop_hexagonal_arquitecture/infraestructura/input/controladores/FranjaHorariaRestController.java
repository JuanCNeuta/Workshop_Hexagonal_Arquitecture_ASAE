package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.controladores;

import java.sql.Time;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionarFranjaCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.Curso;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.FranjaDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.FranjaDTORespuesta;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers.FranjaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FranjaHorariaRestController {
    private final GestionarFranjaCUIntPort objGestionFranjasCUInt;
    private final FranjaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/Franjas/{cursoId}/{espacioFisicoId}")
    public ResponseEntity<FranjaDTORespuesta> create(
            @RequestBody @Valid FranjaDTOPeticion objFranja,
            @PathVariable Integer cursoId,
            @PathVariable Integer espacioFisicoId,
            @RequestParam String dia,
            @RequestParam Time horaInicio,
            @RequestParam Time horaFin) {

        FranjaHoraria objFranjaCrear = objMapeador.mappearDePeticionAFranja(objFranja);

        // Asociar el espacio físico y curso existentes utilizando los IDs proporcionados en la URL
        EspacioFisico espacioFisico = new EspacioFisico();
        espacioFisico.setIdEspacioFisico(espacioFisicoId);
        
        Curso curso = new Curso();
        curso.setIdCurso(cursoId);

        // Asignar espacio físico y curso a la franja horaria
        objFranjaCrear.setObjEspacioFisico(espacioFisico);
        objFranjaCrear.setObjCurso(curso);


        FranjaHoraria objFranjaCreado = objGestionFranjasCUInt.crear(objFranjaCrear, null, null, null, null);
        ResponseEntity<FranjaDTORespuesta> objRespuesta = new ResponseEntity<FranjaDTORespuesta>(
                objMapeador.mappearDeFranjaARespuesta(objFranjaCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/Franjas")
    public ResponseEntity<List<FranjaDTORespuesta>> listar(
            @Valid @RequestParam(value = "patron", required = false, defaultValue = "") String patron,
            @RequestParam(value = "capacidad", required = false, defaultValue = "0") int capacidad) {
        ResponseEntity<List<FranjaDTORespuesta>> objRespuesta = new ResponseEntity<List<FranjaDTORespuesta>>(
                objMapeador.mappearDeFranjasARespuesta(this.objGestionFranjasCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
}
