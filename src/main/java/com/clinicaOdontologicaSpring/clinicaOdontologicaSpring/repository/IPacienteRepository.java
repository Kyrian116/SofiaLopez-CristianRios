package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    //Si quisiera traer un listado
    //List<PacienteDTO> traerPacientePorDni(String dni);
    //Traer paciente por dni
  //  PacienteDTO buscarPacientePorDni(String dni);
    //Lo tengo que llamar desde el Service
    //@Query(nativeQuery = true, value = "SELECT * FROM PACIENTES WHERE DNI = :DNI")
    //Optional<Paciente> buscarPacientePorDni(String dni);
   // @Query("from Paciente p where p.dni like %:dni%") //nombre de la entidad de las clases, no las tablas
    //Set<Paciente> getPacienteByDni(@Param("dni")String dni);
    @Query("SELECT p FROM Paciente p JOIN FETCH p.domicilio WHERE p.id = :id")
    Paciente findByIdWithDomicilio(@Param("id") Long id);

    Set<Paciente> findByDni(String dni);
}
