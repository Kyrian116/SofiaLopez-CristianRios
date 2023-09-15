package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.OdontologoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.PacienteDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto.TurnoDTO;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.BadRequestException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.ResourceNotFoundException;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions.TurnoNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface ITurnoService {

    public TurnoDTO crearTurno(TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException;
    public TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException;
    public TurnoDTO modificarTurno(TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException;
    public void eliminarTurno(Long id) throws TurnoNotFoundException, TurnoNotFoundException;
    public List<TurnoDTO> listarTurnos() throws ResourceNotFoundException;
}
