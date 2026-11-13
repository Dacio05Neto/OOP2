package com.aula.oop.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false, unique = true)
    private String emailUsuario;

    @Column(nullable = false)
    private String senhaUsuario;

    @Column(nullable = false)
    private String numeroTelefoneUsuario;


}
