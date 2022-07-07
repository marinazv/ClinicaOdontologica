package com.proyectoFinal.ClinicaOdontologica.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoFinal.ClinicaOdontologica.model.DomicilioDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Paciente;
import com.proyectoFinal.ClinicaOdontologica.model.PacienteDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private  IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper maper;

    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {

        Paciente paciente = maper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public Set<PacienteDTO> listarTodosLosPacientes() {
        List<Paciente> pacientes= pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO= new HashSet<>();
        for (Paciente p: pacientes) {
            pacientesDTO.add(maper.convertValue(p,PacienteDTO.class));
            }


        return pacientesDTO;
    }

    @Override
    public PacienteDTO buscarPacientePorId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO= null;
        if (paciente.isPresent())
            pacienteDTO = maper.convertValue(paciente, PacienteDTO.class);

        return pacienteDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
