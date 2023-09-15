package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
}
