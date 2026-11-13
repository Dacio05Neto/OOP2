package com.aula.oop.app.repository;

import com.aula.oop.app.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    boolean existsByEmailUsuario(String emailUsuario);


}
