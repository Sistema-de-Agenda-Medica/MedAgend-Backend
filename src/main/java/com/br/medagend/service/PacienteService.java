package com.br.medagend.service;

import com.br.medagend.Interface.IPacienteService;
import com.br.medagend.models.Pacientes;
import com.br.medagend.repository.PacientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService implements IPacienteService {

    private PacientesRepository pacientesRepository;

    @Override
    public Optional<Pacientes> findById(UUID id) {
        return pacientesRepository.findById(id);
    }

    @Override
    public List<Pacientes> findAll() {
        return pacientesRepository.findAll();
    }

    @Override
    public Pacientes save(Pacientes pacientes) {
        return pacientesRepository.save(pacientes);
    }

    @Override
    public void delete(UUID id) {
        pacientesRepository.deleteById(id);
    }
}
