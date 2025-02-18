package com.triSynch.estoqueAlmoxarifado.controllers;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();

    }

    @PostMapping
    public void post(@RequestBody UserDTO user) {
        userService.post(user);

    }

    @PutMapping
    public UserDTO put(@RequestBody UserDTO user) {
        return userService.put(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {

        userService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
