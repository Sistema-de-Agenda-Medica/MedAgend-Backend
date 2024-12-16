package com.br.medagend.models;

import com.br.medagend.enums.TIPO_ENUM;
import com.br.medagend.request.LoginRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "tb_usuarios")
@NoArgsConstructor @AllArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TIPO_ENUM type;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false, updatable = false)
    private Timestamp createdIn;

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.getPassword(), this.password);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TIPO_ENUM getType() {
        return type;
    }

    public void setType(TIPO_ENUM type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Timestamp getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(Timestamp createdIn) {
        this.createdIn = createdIn;
    }
}
