package com.br.medagend.Interface;

import com.br.medagend.models.Medicos;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IMedicosService {
    Optional<Medicos> findById(UUID id);
    List<Medicos> findAll();
    Medicos save(Medicos medico);
    void delete(UUID id);
    Optional<Medicos> findByCrm(String crm);
}
