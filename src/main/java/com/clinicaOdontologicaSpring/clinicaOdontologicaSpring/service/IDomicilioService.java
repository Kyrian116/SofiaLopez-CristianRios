package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.DomicilioDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;

import java.util.Set;

public interface IDomicilioService {
    public void crearDomicilio(DomicilioDTO domicilioDTO);
    public DomicilioDTO buscarDomicilio(Long id) throws BadRequestException;
    public void modificarDomicilio(DomicilioDTO domicilioDTO);
    public void eliminarDomicilio(Long id);
    public Set<DomicilioDTO> listarDomicilios();
}
