package co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.aplicacion.input.GestionEspacioCUIntPort;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTOPeticion.EspacioDTOPeticion;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.DTORespuesta.EspacioDTORespuesta;
import co.edu.unicauca.asae.workshop_hexagonal_arquitecture.infraestructura.input.mappers.EspacioMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EspacioFisicoRestController {

    private final GestionEspacioCUIntPort objGestionEspaciosCUInt;
    private final EspacioMapperInfraestructuraDominio objMapeador;
    
    @PostMapping("/espacios")
    public ResponseEntity<EspacioDTORespuesta> create(@RequestBody @Valid EspacioDTOPeticion objEspacio) {
        EspacioFisico objEspacioCrear = objMapeador.mappearDePeticionAEspacio(objEspacio);
        EspacioFisico objEspacioCreado = objGestionEspaciosCUInt.crear(objEspacioCrear);
        ResponseEntity<EspacioDTORespuesta> objRespuesta = new ResponseEntity<EspacioDTORespuesta>(
                objMapeador.mappearDeEspacioARespuesta(objEspacioCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/espacios")
    public ResponseEntity<List<EspacioDTORespuesta>> listar(@Valid
        @RequestParam(value = "patron", required = false, defaultValue = "") String patron,
        @RequestParam(value = "capacidad", required = false, defaultValue = "0") int capacidad) {
        ResponseEntity<List<EspacioDTORespuesta>> objRespuesta = new ResponseEntity<List<EspacioDTORespuesta>>(
                objMapeador.mappearDeEspaciosARespuesta(this.objGestionEspaciosCUInt.listar(patron,capacidad)),
                HttpStatus.OK);
        return objRespuesta;
    }
}
