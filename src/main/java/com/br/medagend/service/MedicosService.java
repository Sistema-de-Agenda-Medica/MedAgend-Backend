package com.br.medagend.service;

import com.br.medagend.Interface.IMedicosService;
import com.br.medagend.models.Medicos;
import com.br.medagend.repository.MedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicosService implements IMedicosService {

    @Autowired
    private MedicosRepository medicosRepository;

    @Override
    public Optional<Medicos> findById(UUID id) {
        return medicosRepository.findById(id);
    }

    @Override
    public List<Medicos> findAll() {
        return medicosRepository.findAll();
    }

    @Override
    public Medicos save(Medicos medico) {
        return medicosRepository.save(medico);
    }

    @Override
    public void delete(UUID id) {
        medicosRepository.deleteById(id);
    }

    @Override
    public Optional<Medicos> findByCrm(String crm) {
        return medicosRepository.findByCrm(crm);
    }
}
