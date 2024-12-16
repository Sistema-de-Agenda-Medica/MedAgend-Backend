package com.br.medagend.service;

import com.br.medagend.Interface.IUsuarioService;
import com.br.medagend.models.Usuarios;
import com.br.medagend.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Override
    public Optional<Usuarios> findById(UUID id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuarios> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuarios save(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(UUID id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuarios> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
