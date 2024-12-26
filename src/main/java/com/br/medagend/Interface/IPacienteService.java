package com.br.medagend.Interface;

import com.br.medagend.models.Pacientes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPacienteService {
    Optional<Pacientes> findById(UUID id);
    List<Pacientes> findAll();
    Pacientes save(Pacientes pacientes);
    void delete(UUID id);
}
