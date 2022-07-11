package com.proyectoFinal.ClinicaOdontologica.Service;


import com.proyectoFinal.ClinicaOdontologica.Exceptions.ResourceNotFoundExceptions;
import com.proyectoFinal.ClinicaOdontologica.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService{
    void guardarTurno(TurnoDTO turnoDTO);
    Set<TurnoDTO> listarTodosLosTurnos();
    TurnoDTO buscarTurnoPorId(Long id) throws ResourceNotFoundExceptions;
    void modificarTurno(TurnoDTO turnoDTO);
    Boolean eliminarTurno(Long id) throws ResourceNotFoundExceptions;
}
