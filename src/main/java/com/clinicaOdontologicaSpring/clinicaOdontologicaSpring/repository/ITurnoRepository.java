package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
