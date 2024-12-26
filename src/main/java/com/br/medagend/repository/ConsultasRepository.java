package com.br.medagend.repository;

import com.br.medagend.enums.StatusConsulta;
import com.br.medagend.models.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, UUID> {
    List<Consultas> findByStatus(StatusConsulta status);
}