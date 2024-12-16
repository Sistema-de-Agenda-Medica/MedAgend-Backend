package com.br.medagend.controller;

import com.br.medagend.Interface.IUsuarioController;
import com.br.medagend.models.Usuarios;
import com.br.medagend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController implements IUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Usuarios getUsuarioById(@PathVariable UUID id) {
        return usuarioService.findById(id).orElse(null);
    }

    @Override
    @PostMapping
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.save(usuario);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable UUID id) {
        usuarioService.delete(id);
    }
}
