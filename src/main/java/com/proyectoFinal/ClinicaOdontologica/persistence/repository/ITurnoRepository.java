package com.proyectoFinal.ClinicaOdontologica.persistence.repository;

import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
