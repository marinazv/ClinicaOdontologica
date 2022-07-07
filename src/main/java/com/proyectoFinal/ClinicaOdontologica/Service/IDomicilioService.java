package com.proyectoFinal.ClinicaOdontologica.Service;

import com.proyectoFinal.ClinicaOdontologica.model.DomicilioDTO;


import java.util.Set;

public interface IDomicilioService {
    void guardarDomicilio(DomicilioDTO domicilioDTO);
    Set<DomicilioDTO> listarTodosLosDomicilios();
    DomicilioDTO buscarDomicilioPorId(Long id);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
}
