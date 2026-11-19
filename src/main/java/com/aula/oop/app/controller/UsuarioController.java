package com.aula.oop.app.controller;

import com.aula.oop.app.dto.LivroResponseDTO;
import com.aula.oop.app.dto.UsuarioRequestDTO;
import com.aula.oop.app.dto.UsuarioResponseDTO;
import com.aula.oop.app.service.LivroService;
import com.aula.oop.app.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponseDTO> addUsuario(@RequestBody @Valid UsuarioRequestDTO usuario){
        UsuarioResponseDTO resposta = usuarioService.addUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsuarioResponseDTO> deletarUsuario(@PathVariable Long id){
       // usuarioService.deletarUsuario(id);
        UsuarioResponseDTO responder = usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(responder);
    }
}
