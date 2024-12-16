package com.br.medagend.models;

import com.br.medagend.enums.TIPO_ENUM;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "tb_usuarios")
@Getter @Setter
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
}
