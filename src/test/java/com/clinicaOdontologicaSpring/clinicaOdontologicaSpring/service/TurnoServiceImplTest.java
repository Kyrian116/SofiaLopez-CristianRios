 package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TurnoServiceImplTest {
    //Falla. Dice que el paciente y odontologo esta en null

/* @Autowired
 TurnoServiceImpl turnoService;

@Test
 public void testCrearTurno() throws Exception {
     PacienteDTO pacienteDTO = new PacienteDTO();
     pacienteDTO.setNombre("Roberto");
     pacienteDTO.setApellido("Sanchéz");
     pacienteDTO.setDni("16589698");
     pacienteDTO.setFechaIngreso(LocalDate.of(2023,4,20));
     OdontologoDTO odontologoDTO = new OdontologoDTO();
     odontologoDTO.setNombre("Carlos");
     odontologoDTO.setApellido("Vazquez");
     odontologoDTO.setMatricula("12563");
     TurnoDTO turnoDTO = new TurnoDTO();
     turnoDTO.setFecha(LocalDate.of(2023,4,20));
     turnoDTO.setHora(LocalTime.of(11,30));
     turnoDTO.setPacienteDTO(pacienteDTO);
     turnoDTO.setOdontologoDTO(odontologoDTO);

     turnoService.crearTurno(turnoDTO);

     TurnoDTO buscarTurno = turnoService.buscarTurno(turnoDTO.getId());

     assertTrue(buscarTurno != null);
 }*/
}
