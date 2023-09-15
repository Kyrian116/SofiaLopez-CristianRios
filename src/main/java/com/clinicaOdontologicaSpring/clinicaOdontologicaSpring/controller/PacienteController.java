package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.controller;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.PacienteDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPacienteId(@PathVariable Long id) throws Exception {
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        pacienteService.eliminarPaciente(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Paciente eliminado");
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        List<PacienteDTO> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }
}
