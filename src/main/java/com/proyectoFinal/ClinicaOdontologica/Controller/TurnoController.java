package com.proyectoFinal.ClinicaOdontologica.Controller;

import com.proyectoFinal.ClinicaOdontologica.Service.ITurnoService;
import com.proyectoFinal.ClinicaOdontologica.Service.TurnoService;
import com.proyectoFinal.ClinicaOdontologica.model.TurnoDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {


    @Autowired
    ITurnoService turnoService;


    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> mostrarTurnos (){
        Set<TurnoDTO> listarTurnos = turnoService.listarTodosLosTurnos();
        return ResponseEntity.ok(listarTurnos);
    }

    @GetMapping("{id}")
    public TurnoDTO mostrarTurnoPorId(@PathVariable Long id){
            return turnoService.buscarTurnoPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDTO turnoDto){
        turnoService.guardarTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarTurnoPorId(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
