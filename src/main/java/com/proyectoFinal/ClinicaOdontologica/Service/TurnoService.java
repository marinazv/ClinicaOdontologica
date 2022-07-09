package com.proyectoFinal.ClinicaOdontologica.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoFinal.ClinicaOdontologica.model.PacienteDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Paciente;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Turno;
import com.proyectoFinal.ClinicaOdontologica.model.TurnoDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.repository.ITurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TurnoService implements ITurnoService{

    private static final Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        try {
            Turno turno = mapper.convertValue(turnoDTO, Turno.class);
            if (turno.getFecha() != turnoDTO.getFecha()) {
                turnoRepository.save(turno);
            }
        } catch (Exception e){
            logger.error("Ya existe un turno en esa fecha");
        };

    }

    @Override
    public Set<TurnoDTO> listarTodosLosTurnos() {
        List<Turno> todosLosTurnos =turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO= new HashSet<>();
        for (Turno t: todosLosTurnos) {
            turnosDTO.add(mapper.convertValue(t, TurnoDTO.class));
        }
        return  turnosDTO;
    }

    @Override
    public TurnoDTO buscarTurnoPorId(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO= null;
        if (turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
