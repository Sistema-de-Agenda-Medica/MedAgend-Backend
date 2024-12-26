package com.br.medagend.controller;

import com.br.medagend.enums.StatusConsulta;
import com.br.medagend.models.Consultas;
import com.br.medagend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<Consultas> agendarConsulta(
            @RequestParam UUID pacienteId,
            @RequestParam UUID medicoId,
            @RequestParam LocalDate data,
            @RequestParam LocalTime horario,
            @RequestParam(required = false) String observacoes) {

        Consultas consulta = consultaService.agendarConsulta(pacienteId, medicoId, data, horario, observacoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }

    @PutMapping("/{consultaId}/status")
    public ResponseEntity<Consultas> alterarStatusConsulta(
            @PathVariable UUID consultaId,
            @RequestParam StatusConsulta status) {

        Consultas consulta = consultaService.alterarStatusConsulta(consultaId, status);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity<List<Consultas>> listarConsultasPorStatus(@RequestParam StatusConsulta status) {
        List<Consultas> consultas = consultaService.listarConsultasPorStatus(status);
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<Consultas> buscarConsultaPorId(@PathVariable UUID consultaId) {
        return consultaService.buscarConsultaPorId(consultaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
