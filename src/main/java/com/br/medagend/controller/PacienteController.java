package com.br.medagend.controller;

import com.br.medagend.models.Pacientes;
import com.br.medagend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Pacientes> getAllPacientes(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Pacientes getPacienteById(@PathVariable UUID id){
        return pacienteService.findById(id).orElse(null);
    }

    @PostMapping
    public Pacientes createPaciente(@RequestBody Pacientes pacientes){
        return pacienteService.save(pacientes);
    }

    @PutMapping("/{id}")
    public Pacientes updatePaciente(@PathVariable UUID id, @RequestBody Pacientes pacientes){
        Pacientes existingPaciente = pacienteService.findById(id).orElseThrow(() ->
                new RuntimeException("Paciente não encontrado com o ID: "+ id));
        existingPaciente.setUsuarios(pacientes.getUsuarios());
        existingPaciente.setBirth(pacientes.getBirth());
        existingPaciente.setAddress(pacientes.getAddress());

        return pacienteService.save(existingPaciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable UUID id){
        pacienteService.delete(id);
    }


}
