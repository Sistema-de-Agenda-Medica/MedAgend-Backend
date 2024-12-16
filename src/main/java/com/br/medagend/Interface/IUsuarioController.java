package com.br.medagend.Interface;

import com.br.medagend.models.Usuarios;

import java.util.List;
import java.util.UUID;

public interface IUsuarioController {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(UUID id);
    Usuarios createUsuario(Usuarios usuario);
    void deleteUsuario(UUID id);
}
