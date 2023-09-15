package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.DomicilioDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.impl.DomicilioServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DomicilioServiceImplTest {

    @Autowired
    DomicilioServiceImpl domicilioService;

    @Test
    public void testCrearDomicilio() throws Exception {

        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Maipú");
        domicilioDTO.setNumero("1523");
        domicilioDTO.setLocalidad("Avellaneda");
        domicilioDTO.setProvincia("Buenos Aires");

        domicilioService.crearDomicilio(domicilioDTO);
        DomicilioDTO buscarDomicilio = domicilioService.buscarDomicilio(1L);


        assertTrue(buscarDomicilio != null);

    }
}