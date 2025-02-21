package com.triSynch.estoqueAlmoxarifado.controllers;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO user) {
        try {
            UserDTO registeredUser = authService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser); // Retorna 201 Created
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason()); // Retorna o erro com status e mensagem
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            UserDTO user = authService.login(username, password);
            return ResponseEntity.ok(user); // Retorna 200 OK com os dados do usuário
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason()); // Retorna o erro com status e mensagem
        }
    }
}