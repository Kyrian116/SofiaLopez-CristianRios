package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.controller;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.OdontologoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*
Lógica:
1. POST --> Creo
2. GET -- Traigo por ID
3. GET --> Traigo el buscar todos
4.
 */

//@Controller sería más generica
@RestController //ApiREST (CRUD) - Respuestas restringidas, no tiene estados. Métodos limitados (CRUD)
@RequestMapping("/odontologo") //PATH para enviar requerimientos
public class OdontologoController {

    //Al tener el @Service agrego @Autowire y no instancio. Automaticamente inyecta la dependentcia
    //Se comunican con la capa de servicio
    //Cuando instancia la app, un objeto de DomicilioService
    @Autowired
    private IOdontologoService odontologoService;

    //Creamos los métodos que necesitamos
    //Agregar odontologo
    //Propiedades con DTO
    @PostMapping
    //ResponseEntity -->  maneja toda la respuesta HTTP incluyendo el cuerpo, cabecera y códigos de estado permitiéndonos total libertad de configurar la respuesta que queremos que se envié desde nuestros endpoints.
    //Usamos RequestBody por que le mando un objeto (para que lo cree y lo mande a la DBA por el Repository)
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        try {
            odontologoService.crearOdontologo(odontologoDTO);
            //Tengo que devolver un ResponseEntity
            //con el odontologoService ejecuto el registrar
            return ResponseEntity.ok(HttpStatus.OK);
            //Me devuelve la entidad ya creada. Con el ok devuelve el status 200
        } catch (Exception e) {
            throw new BadRequestException("No se pudo crear el odontologo");
        }
    }

    //Buscar odontologo por ID
    //Propiedades con DTO
    @GetMapping("/{id}")
    //Recibimos por PATH el ID
                                                 //Parámetros
    public OdontologoDTO buscarOdontologoId(@PathVariable Long id) throws Exception {
        return odontologoService.buscarOdontologo(id);
    }

    //Modificar odontologo (Similar al crear)
    @PutMapping("/modificar")
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Eliminar odontologo
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        odontologoService.eliminarOdontologo(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Odontologo eliminado");
        return response;
    }

    //Listar todos los odontologos
    //Devuelve una coleccion!
    @GetMapping("/listar")
    //NO olvidar agregar el List!!   //No agregamos parámetros
    public Collection<OdontologoDTO> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }

}
