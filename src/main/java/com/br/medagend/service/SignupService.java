package com.br.medagend.service;

import com.br.medagend.Interface.ISignupService;
import com.br.medagend.enums.TIPO_ENUM;
import com.br.medagend.models.Usuarios;
import com.br.medagend.repository.UsuariosRepository;
import com.br.medagend.request.SignupRequest;
import com.br.medagend.response.SignupResponse;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class SignupService implements ISignupService {

    private final UsuariosRepository usuariosRepository;

    public SignupService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public SignupResponse signup(SignupRequest signupRequest) {
        Optional<Usuarios> existingUsuario = usuariosRepository.findByEmail(signupRequest.getEmail());
        if (existingUsuario.isPresent()) {
            throw new IllegalArgumentException("Erro: O e-mail já está cadastrado.");
        }

        Usuarios usuario = new Usuarios();
        usuario.setName(signupRequest.getName());
        usuario.setEmail(signupRequest.getEmail());
        usuario.setPassword(signupRequest.getPassword());
        usuario.setContact(signupRequest.getContact());
        usuario.setType(TIPO_ENUM.PACIENTE);
        usuario.setCreatedIn(new Timestamp(System.currentTimeMillis()));

        usuariosRepository.save(usuario);

        return new SignupResponse(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getType().toString(),
                usuario.getContact(),
                usuario.getCreatedIn().toString()
        );
    }
}