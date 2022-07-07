package com.proyectoFinal.ClinicaOdontologica.persistence.entities;

import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Odontologo;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Paciente;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Turnos")
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    private Date fecha; //creo que no se pedida esto busacar consigna

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    /*public Turno(Date fecha, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }*/

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }


    @Override
    public String toString() {
        return "Turno{" +
                "fecha='" + fecha + '\'' +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }
}
