package com.proyectoFinal.ClinicaOdontologica.persistence.repository;

import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {
}
