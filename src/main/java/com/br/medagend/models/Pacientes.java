package com.br.medagend.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_pacientes")
public class Pacientes {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuarios;
    @Column(name = "birth", nullable = false)
    private LocalDate birth;
    @Column(nullable = false)
    private String address;

    public Pacientes() {
    }

    public Pacientes(UUID id, Usuarios usuarios, LocalDate birth, String address) {
        this.id = id;
        this.usuarios = usuarios;
        this.birth = birth;
        this.address = address;
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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
