package com.triSynch.estoqueAlmoxarifado.controllers;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO user){
        return authService.register(user);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestParam String username, @RequestParam String password){
        return authService.login(username, password);
    }
}
