package com.proyectoFinal.ClinicaOdontologica.Service;

import com.proyectoFinal.ClinicaOdontologica.model.PacienteDTO;

import java.util.Optional;
import java.util.Set;

public interface IPacienteService {

    void guardarPaciente(PacienteDTO pacienteDTO);
    Set<PacienteDTO> listarTodosLosPacientes();
    PacienteDTO buscarPacientePorId(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
}
