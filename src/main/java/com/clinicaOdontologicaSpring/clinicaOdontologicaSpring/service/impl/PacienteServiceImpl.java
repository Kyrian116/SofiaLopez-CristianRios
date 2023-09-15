package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.impl;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.DomicilioDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.PacienteDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.Domicilio;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.Paciente;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.PacienteNotFoundException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.ResourceNotFoundException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IDomicilioRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IPacienteRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;

    @Autowired
    public PacienteServiceImpl(IPacienteRepository pacienteRepository, IDomicilioRepository domicilioRepository) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioRepository = domicilioRepository;
    }

    private void guardarPaciente(PacienteDTO pacienteDTO) {
        Domicilio domicilio = mapper.convertValue(pacienteDTO.getDomicilio(), Domicilio.class);
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        paciente.setDomicilio(domicilio);
        pacienteRepository.save(paciente);
    }


    @Override
    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) throws BadRequestException, ResourceNotFoundException {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + id));
        PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        DomicilioDTO domicilioDTO = mapper.convertValue(paciente.getDomicilio(), DomicilioDTO.class);
        pacienteDTO.setDomicilio(domicilioDTO);
        return pacienteDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {

        guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> pacientesDTO = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            DomicilioDTO domicilioDTO = mapper.convertValue(paciente.getDomicilio(), DomicilioDTO.class);
            pacienteDTO.setDomicilio(domicilioDTO);
            pacientesDTO.add(pacienteDTO);
        }

        return pacientesDTO;
    }
}
