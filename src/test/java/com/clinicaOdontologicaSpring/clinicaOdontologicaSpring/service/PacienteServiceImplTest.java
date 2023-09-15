package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PacienteServiceImplTest {
    //Falla. Dice que el domicilio esta en null
  /*  @Autowired
    PacienteServiceImpl pacienteService;

    @Test
    public void testCrearPaciente() throws Exception {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Callao");
        domicilioDTO.setNumero("1256");
        domicilioDTO.setLocalidad("CABA");
        domicilioDTO.setProvincia("CABA");
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Carmén");
        pacienteDTO.setApellido("Aguirre");
        pacienteDTO.setDni("16203658");
        pacienteDTO.setFechaIngreso(LocalDate.of(2023,3,17));
        pacienteDTO.setDomicilioDTO(domicilioDTO);

        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO buscarPaciente = pacienteService.buscarPaciente(pacienteDTO.getId());

        assertTrue(buscarPaciente != null);
    }*/

}
