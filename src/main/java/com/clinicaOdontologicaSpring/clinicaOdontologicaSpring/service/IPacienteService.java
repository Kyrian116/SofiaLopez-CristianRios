package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.PacienteDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.ResourceNotFoundException;

import java.util.Collection;
import java.util.List;

public interface IPacienteService {
    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO);
    public PacienteDTO buscarPaciente(Long id) throws BadRequestException, ResourceNotFoundException;
    public void modificarPaciente(PacienteDTO pacienteDTO);
    public void eliminarPaciente(Long id);
    public List<PacienteDTO> listarPacientes();
    //Este solo se implementó por el ejemplo de HQL

}
