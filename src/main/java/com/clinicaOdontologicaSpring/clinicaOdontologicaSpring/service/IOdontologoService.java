package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.OdontologoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;

import java.util.Collection;

public interface IOdontologoService {
    public void crearOdontologo(OdontologoDTO odontologoDTO);
    public OdontologoDTO buscarOdontologo(Long id) throws BadRequestException;
    public void modificarOdontologo(OdontologoDTO odontologoDTO);
    public void eliminarOdontologo(Long id);
    public Collection<OdontologoDTO> listarOdontologos();
}
