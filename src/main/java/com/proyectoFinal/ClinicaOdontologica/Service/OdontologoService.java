package com.proyectoFinal.ClinicaOdontologica.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Odontologo;
import com.proyectoFinal.ClinicaOdontologica.model.OdontologoDTO;
import com.proyectoFinal.ClinicaOdontologica.persistence.repository.IOdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class OdontologoService implements IOdontologoService {

    private static final Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo= mapper.convertValue(odontologoDTO,Odontologo.class);
        odontologoRepository.save(odontologo);
        logger.info("Se guardo el Odontologo"+ odontologoDTO);
    }

    @Override
    public Set<OdontologoDTO> listarTodosLosOdontologos() {
        List<Odontologo> odontologos= odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO= new HashSet<>();
        for (Odontologo o: odontologos) {
            odontologosDTO.add(mapper.convertValue(o,OdontologoDTO.class));
        }
        return odontologosDTO;

    }

    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO= null;
        if (odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);

        return odontologoDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }
}
