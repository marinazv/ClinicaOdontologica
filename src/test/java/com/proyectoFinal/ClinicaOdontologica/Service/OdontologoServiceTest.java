package com.proyectoFinal.ClinicaOdontologica.Service;

import static org.junit.jupiter.api.Assertions.*;

import com.proyectoFinal.ClinicaOdontologica.model.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import org.apache.log4j.Logger;

@SpringBootTest
class OdontologoServiceTest {


    @Autowired
    IOdontologoService odontologoService;

    @Test
    public void testGuardarOdontologo(){
        OdontologoDTO odontologoTest = new OdontologoDTO();
        odontologoTest.setNombre("Belen");
        odontologoTest.setApellido("Zurita");

        odontologoService.guardarOdontologo(odontologoTest);

        OdontologoDTO odonto= odontologoService.buscarOdontologoPorId(1L);

        assertNotNull(odonto);
    }
    @Test
    public void listarTodosLosOdontologosTest(){
        Set<OdontologoDTO> listaOdonontologos= odontologoService.listarTodosLosOdontologos();
        assertNotNull(listaOdonontologos);
    }
   /*@Test
    public void elimnarOdontologoTest(){
        odontologoService.eliminarOdontologo(1L);

    }*/

}