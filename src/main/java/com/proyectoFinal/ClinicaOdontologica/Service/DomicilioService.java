package com.proyectoFinal.ClinicaOdontologica.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Domicilio;
import com.proyectoFinal.ClinicaOdontologica.model.DomicilioDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public Set<DomicilioDTO> listarTodosLosDomicilios() {
        List<Domicilio> domicilios= domicilioRepository.findAll();
        Set<DomicilioDTO> domiciliosDTO= new HashSet<>();
        for (Domicilio d: domicilios) {
            domiciliosDTO.add(mapper.convertValue(d,DomicilioDTO.class));
        }
        return domiciliosDTO;
    }

    @Override
    public DomicilioDTO buscarDomicilioPorId(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO= null;
        if (domicilio.isPresent()) {
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }
}
