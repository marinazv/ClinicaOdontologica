package com.proyectoFinal.ClinicaOdontologica.Service;


import com.proyectoFinal.ClinicaOdontologica.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void guardarTurno(TurnoDTO turnoDTO);
    Set<TurnoDTO> listarTodosLosTurnos();
    TurnoDTO buscarTurnoPorId(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
}
