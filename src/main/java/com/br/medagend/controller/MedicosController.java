package com.br.medagend.controller;

import com.br.medagend.models.Medicos;
import com.br.medagend.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {

    private final MedicosService medicosService;

    @Autowired
    public MedicosController(MedicosService medicosService) {
        this.medicosService = medicosService;
    }

    @GetMapping
    public List<Medicos> getAllMedicos() {
        return medicosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicos> getMedicoById(@PathVariable UUID id) {
        Optional<Medicos> medico = medicosService.findById(id);
        return medico.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Medicos> createMedico(@RequestBody Medicos medico) {
        Optional<Medicos> existingMedico = medicosService.findByCrm(medico.getCrm());
        if (existingMedico.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Medicos savedMedico = medicosService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicos> updateMedico(@PathVariable UUID id, @RequestBody Medicos medicoDetails) {
        Optional<Medicos> medico = medicosService.findById(id);
        if (medico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Medicos existingMedico = medico.get();
        existingMedico.setSpecialty(medicoDetails.getSpecialty());
        existingMedico.setAvailableSchedule(medicoDetails.getAvailableSchedule());
        existingMedico.setCrm(medicoDetails.getCrm());

        Medicos updatedMedico = medicosService.save(existingMedico);
        return ResponseEntity.ok(updatedMedico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable UUID id) {
        Optional<Medicos> medico = medicosService.findById(id);
        if (medico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        medicosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
