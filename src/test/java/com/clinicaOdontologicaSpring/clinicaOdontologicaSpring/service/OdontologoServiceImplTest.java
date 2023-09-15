package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.OdontologoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.impl.OdontologoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OdontologoServiceImplTest {

    @Autowired
    OdontologoServiceImpl odontologoService;
    @Test
    public void testCrearOodntologo() throws Exception {

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Carlos");
        odontologoDTO.setApellido("Guerrero");
        odontologoDTO.setMatricula("125639");

        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO buscarOdontologo = odontologoService.buscarOdontologo(1L);

        assertTrue(buscarOdontologo != null);
    }
}
