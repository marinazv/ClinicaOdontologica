package com.proyectoFinal.ClinicaOdontologica.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoFinal.ClinicaOdontologica.Exceptions.ResourceNotFoundExceptions;
import com.proyectoFinal.ClinicaOdontologica.model.PacienteDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Paciente;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Turno;
import com.proyectoFinal.ClinicaOdontologica.model.TurnoDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.repository.ITurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
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
    public void guardarTurno(TurnoDTO turnoDTO)  {
        Set<TurnoDTO> listaTurnos = listarTodosLosTurnos();
        boolean existeTurno = false;
           for (TurnoDTO t : listaTurnos) {
                if (t.getFecha() == turnoDTO.getFecha()) {
                    existeTurno = true;
                }
            }
           try{
            if (!existeTurno && (turnoDTO.getFecha().isAfter(LocalDate.now()))){
                Turno turno = mapper.convertValue(turnoDTO, Turno.class);
                turnoRepository.save(turno);
            }
        }catch (Exception e){
               logger.error("No es posible cargar el turno en esa fecha");
           }
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
    public TurnoDTO buscarTurnoPorId(Long id) throws ResourceNotFoundExceptions{
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO= null;
        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        else{
            new ResourceNotFoundExceptions("No existe un turno con el id: "+ id);
        }
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public Boolean eliminarTurno(Long id) throws ResourceNotFoundExceptions{
        boolean res= false;
        if (buscarTurnoPorId(id)== null){
            throw new ResourceNotFoundExceptions("No existe un turno con id:"+ id+" para eliminar");
        }else {
            turnoRepository.deleteById(id);
            res = true;
        }
        return  res;
    }

}
