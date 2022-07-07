package com.proyectoFinal.ClinicaOdontologica.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Turno;
import com.proyectoFinal.ClinicaOdontologica.model.TurnoDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public Set<TurnoDTO> listarTodosLosTurnos() {
        return null;
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
