package com.br.medagend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_medicos")
public class Medicos {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuarios;
    @Column(nullable = false)
    private String specialty;
    @Column(nullable = false, unique = true)
    private String crm;
    @Column(name = "available_Schedule")
    private String availableSchedule;


    public Medicos() {
    }

    public Medicos(UUID id, Usuarios usuarios, String specialty, String crm, String availableSchedule) {
        this.id = id;
        this.usuarios = usuarios;
        this.specialty = specialty;
        this.crm = crm;
        this.availableSchedule = availableSchedule;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getAvailableSchedule() {
        return availableSchedule;
    }

    public void setAvailableSchedule(String availableSchedule) {
        this.availableSchedule = availableSchedule;
    }
}
