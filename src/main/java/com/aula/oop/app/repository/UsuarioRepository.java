package com.aula.oop.app.repository;

import com.aula.oop.app.model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    boolean existsByEmailUsuario(String emailUsuario);

    Optional<UsuarioModel> findByEmailUsuario(String emailUsuario);


}
