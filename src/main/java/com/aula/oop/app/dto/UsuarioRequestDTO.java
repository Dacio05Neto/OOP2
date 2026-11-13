package com.aula.oop.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @Size(min = 3, max = 100, message = "Nome deve ser maior que 3 caracteres")
    private String nomeUsuario;

    @NotBlank
    @Size(min = 1, max = 200, message = "email com tamanho incorreto")
    private String emailUsuario;

    @NotBlank
    private String senhaUsuario;

    private String numeroTelefoneUsuario;


}
