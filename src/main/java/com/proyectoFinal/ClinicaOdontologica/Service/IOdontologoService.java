package com.proyectoFinal.ClinicaOdontologica.Service;


import com.proyectoFinal.ClinicaOdontologica.model.OdontologoDTO;


import java.util.Set;
import java.util.logging.Logger;

public interface IOdontologoService {

    void guardarOdontologo(OdontologoDTO odontologoDTO);
    Set<OdontologoDTO> listarTodosLosOdontologos();
    OdontologoDTO buscarOdontologoPorId(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
}
