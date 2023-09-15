package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.controller;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.TurnoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.ResourceNotFoundException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.TurnoNotFoundException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IOdontologoRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IPacienteRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IOdontologoService;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IPacienteService;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IOdontologoService odontologoService;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @PostMapping
    public ResponseEntity<TurnoDTO> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        try {
            TurnoDTO nuevoTurno = turnoService.crearTurno(turnoDTO);
            return ResponseEntity.ok(nuevoTurno);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTurnoId(@PathVariable("id") Long id) {
        try {
            TurnoDTO turnoDTO = turnoService.buscarTurno(id);
            return ResponseEntity.ok(turnoDTO);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) {
        try {
            TurnoDTO modificarTurno = turnoService.modificarTurno(turnoDTO);
            return ResponseEntity.ok(modificarTurno);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) {
        try {
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar el turno. Asegúrate de que el turno existe.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TurnoDTO>> listarTurnos() {
        List<TurnoDTO> turnosDTO = null;
        try {
            turnosDTO = turnoService.listarTurnos();
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(turnosDTO);
    }
}

