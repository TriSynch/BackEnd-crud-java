package com.trysync.batabase_user.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1__create-table-usuario.sql/usuarios")


public class UsuarioController {
    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok("deu ok");

    }
}
