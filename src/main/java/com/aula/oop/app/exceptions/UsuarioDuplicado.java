package com.aula.oop.app.exceptions;

public class UsuarioDuplicado extends RuntimeException {
    public UsuarioDuplicado(String message) {

        super(message);
    }
}
