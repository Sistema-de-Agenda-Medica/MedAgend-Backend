package com.br.medagend.repository;

import com.br.medagend.models.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, UUID> {
}