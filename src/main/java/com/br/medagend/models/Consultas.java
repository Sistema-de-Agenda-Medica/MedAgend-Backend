package com.br.medagend.models;

import com.br.medagend.enums.StatusConsulta;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tb_consultas")
public class Consultas {

    @Id
    @GeneratedValue()
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Pacientes paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medicos medico;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status;

    @Column(length = 500)
    private String observacoes;

    public Consultas() {
    }

    public Consultas(UUID id, Pacientes paciente, Medicos medico, LocalDate data, LocalTime horario, StatusConsulta status, String observacoes) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.observacoes = observacoes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
