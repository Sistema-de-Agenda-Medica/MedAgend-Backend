package com.br.medagend.Interface;

import com.br.medagend.enums.StatusConsulta;
import com.br.medagend.models.Consultas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IConsultaService {
    Consultas agendarConsulta(UUID pacienteId, UUID medicoId, LocalDate data, LocalTime horario, String observacoes);

    Consultas alterarStatusConsulta(UUID consultaId, StatusConsulta novoStatus);

    List<Consultas> listarConsultasPorStatus(StatusConsulta status);

    Optional<Consultas> buscarConsultaPorId(UUID consultaId);
}
