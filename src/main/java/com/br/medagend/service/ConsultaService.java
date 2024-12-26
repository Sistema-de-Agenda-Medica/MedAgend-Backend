package com.br.medagend.service;

import com.br.medagend.Interface.IConsultaService;
import com.br.medagend.enums.StatusConsulta;
import com.br.medagend.models.Consultas;
import com.br.medagend.models.Medicos;
import com.br.medagend.models.Pacientes;
import com.br.medagend.repository.ConsultasRepository;
import com.br.medagend.repository.MedicosRepository;
import com.br.medagend.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ConsultaService implements IConsultaService {
    @Autowired
    private ConsultasRepository consultaRepository;

    @Autowired
    private PacientesRepository pacienteRepository;

    @Autowired
    private MedicosRepository medicoRepository;

    @Override
    public Consultas agendarConsulta(UUID pacienteId, UUID medicoId, LocalDate data, LocalTime horario, String observacoes) {
        Pacientes paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Medicos medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        Consultas consulta = new Consultas();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setObservacoes(observacoes);
        consulta.setStatus(StatusConsulta.AGENDADA);

        return consultaRepository.save(consulta);
    }

    @Override
    public Consultas alterarStatusConsulta(UUID consultaId, StatusConsulta novoStatus) {
        Consultas consulta = consultaRepository.findById(consultaId)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setStatus(novoStatus);
        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consultas> listarConsultasPorStatus(StatusConsulta status) {
        return consultaRepository.findByStatus(status);
    }

    @Override
    public Optional<Consultas> buscarConsultaPorId(UUID consultaId) {
        return consultaRepository.findById(consultaId);
    }
}
