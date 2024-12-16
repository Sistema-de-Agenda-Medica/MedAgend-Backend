package com.br.medagend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_medicos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
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
}
