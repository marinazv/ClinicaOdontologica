package com.proyectoFinal.ClinicaOdontologica.persistence.repository;

import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
