package com.br.medagend.controller;

import com.br.medagend.models.Usuarios;
import com.br.medagend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuarios getUsuarioById(@PathVariable UUID id) {
        return usuarioService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable UUID id) {
        usuarioService.delete(id);
    }
}

