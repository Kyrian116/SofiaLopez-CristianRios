package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.impl;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.OdontologoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.Odontologo;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IOdontologoRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//Inyección de dependencia. Inversion of control.
//Service: Capa que maneja los servicios y/o metodos que voy a implementar en la lógica de negocios
//Los implementaremos en otra clase para que controle la clase donde es implementada
public class OdontologoServiceImpl implements IOdontologoService {

    //Repository traemos como propiedad y creamos constructor
    @Autowired
    private IOdontologoRepository odontologoRepository;

    //Esta capa se encargar de mapear los DTO en las clases de negocio
    // Usa ObjectMapper para convertir objetos a Json
    @Autowired
    ObjectMapper mapper;

    private void guardarOdontologo(OdontologoDTO ondontolgoDTO) {
        //Armamos un método para código repetido
        //Transformamos el estudianteDTO a Objeto de tipo Odontologo con el mapper
        //Las propiedades que se llaman igual, las asigna
        Odontologo odontologo = mapper.convertValue(ondontolgoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    //Método HTTP: POST
    //odontologo es un objeto, ese objeto es un body --> Request Body
    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        //Utilizo el método guardarOdontologo
        guardarOdontologo(odontologoDTO);

    }

    //Método HTTP: GET
    //Por estar buscando por ID se puede usar Request Param o
    //PATH Variable (recomendable)
    @Override
    public OdontologoDTO buscarOdontologo(Long id) throws BadRequestException {
        //Optional nos permite averiguar si el contenido esta nulo o no
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        //Si el odontologo no es nullo
        if (odontologo.isPresent()) {
            //Lo convertimos en un OdontologoDTO
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            return odontologoDTO;
        } else
            throw new BadRequestException("El ID: " + id + " no existe");
    }

    //Método HTTP: PUT
    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    //Método HTTP: DELETE
    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    //Método HTTP: GET
    //Devolver una lista
    @Override
    public Collection<OdontologoDTO> listarOdontologos() {

        List<Odontologo> odontologos = odontologoRepository.findAll();
        //Recorremos la lista y, por cada odontologo, llenamos otra lista
        //con odontologosDTO. Recorremos y llenamos
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        //Recorro la colección de odontologos y lleno otra, donde tranformamos
        //al estudianteDTO
        for (Odontologo odontologo : odontologos)
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        return odontologosDTO;
    }

    public Odontologo findByMatricula(String matricula) {
        Odontologo odontologoFind = null;
        List<Odontologo> odontologos = odontologoRepository.findAll();
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getMatricula().equals(matricula)) {
                odontologoFind = odontologo;
            }
        }
        return odontologoFind;
    }
}

