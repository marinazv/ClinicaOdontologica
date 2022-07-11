package com.proyectoFinal.ClinicaOdontologica.Controller;


import com.proyectoFinal.ClinicaOdontologica.Service.IPacienteService;
import com.proyectoFinal.ClinicaOdontologica.model.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController{
    @Autowired
    IPacienteService pacienteService;


    @GetMapping("/all")
    public ResponseEntity<Set<PacienteDTO>> mostrarPacientes (){
        Set<PacienteDTO> listarPaciente = pacienteService.listarTodosLosPacientes();
        return ResponseEntity.ok(listarPaciente);
    }

    @GetMapping("/{id}")
    public PacienteDTO mostrarPacientePorId(@PathVariable Long id){
        return pacienteService.buscarPacientePorId(id);
    }

    @PostMapping
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO pacienteDTO){
         pacienteService.guardarPaciente(pacienteDTO);
         return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPacientePorId(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
