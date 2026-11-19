package com.aula.oop.app.service;

import com.aula.oop.app.dto.UsuarioRequestDTO;
import com.aula.oop.app.dto.UsuarioResponseDTO;
import com.aula.oop.app.exceptions.UsuarioDuplicado;
import com.aula.oop.app.model.UsuarioModel;
import com.aula.oop.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO addUsuario(UsuarioRequestDTO dto){

        boolean exists = usuarioRepository.existsByEmailUsuario(dto.getEmailUsuario());

        if (exists){
            throw new UsuarioDuplicado("E-mail de usuário já existente" + dto.getEmailUsuario());
        }

        UsuarioModel entity = dtoToEntity(dto);
        return entityToResponseDto(usuarioRepository.save(entity));
    }

    private UsuarioModel dtoToEntity(UsuarioRequestDTO dto){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmailUsuario(dto.getEmailUsuario());
        usuario.setSenhaUsuario(dto.getSenhaUsuario());
        usuario.setNumeroTelefoneUsuario(dto.getNumeroTelefoneUsuario());

        return usuario;
    }

    private UsuarioResponseDTO entityToResponseDto(UsuarioModel usuario){
        return new UsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getNomeUsuario()
        );
    }
}
