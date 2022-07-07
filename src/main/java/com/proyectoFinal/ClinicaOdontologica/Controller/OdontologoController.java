package com.proyectoFinal.ClinicaOdontologica.Controller;

import com.proyectoFinal.ClinicaOdontologica.Service.OdontologoService;
import com.proyectoFinal.ClinicaOdontologica.model.OdontologoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

        OdontologoService odontologoService;

        public OdontologoController(OdontologoService odontologoService) {
            this.odontologoService = odontologoService;
        }

        @GetMapping
        public ResponseEntity<Set<OdontologoDTO>> mostrarOdontologo(){
            Set<OdontologoDTO> listarOdontologos = odontologoService.listarTodosLosOdontologos();
            return ResponseEntity.ok(listarOdontologos);
        }

        @GetMapping("{id}")
        public OdontologoDTO mostrarOdontologoPorId(@PathVariable Long id){
            return odontologoService.buscarOdontologoPorId(id);
        }

        @PostMapping
        public ResponseEntity<?> guardarOdontologo(@RequestBody OdontologoDTO odontologodto){
            odontologoService.guardarOdontologo(odontologodto);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> eliminarOdontologoPorId(@PathVariable Long id){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }

}
