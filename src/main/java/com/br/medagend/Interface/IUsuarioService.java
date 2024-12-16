package com.br.medagend.Interface;

import com.br.medagend.models.Usuarios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUsuarioService {
    Optional<Usuarios> findById(UUID id);
    List<Usuarios> findAll();
    Usuarios save(Usuarios usuario);
    void delete(UUID id);
    Optional<Usuarios> findByEmail(String email);
}