package com.proyectoFinal.ClinicaOdontologica.persistence.repository;

import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
}
