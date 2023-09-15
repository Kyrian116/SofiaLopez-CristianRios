package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.controller;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.DomicilioDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private IDomicilioService domicilioService;

    @PostMapping()
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscarDomicilioId(@PathVariable Long id) throws Exception {
        return domicilioService.buscarDomicilio(id);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        domicilioService.eliminarDomicilio(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Domicilio eliminado");
        return response;
    }

    @GetMapping("/listar")
   public ResponseEntity<Collection<DomicilioDTO>> listarTurnos() {

        return ResponseEntity.ok(domicilioService.listarDomicilios());
        }
    }
