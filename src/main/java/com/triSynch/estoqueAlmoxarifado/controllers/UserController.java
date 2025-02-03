package com.triSynch.estoqueAlmoxarifado.controllers;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getAll();

    }

    @PostMapping

    public void post(@RequestBody UserDTO user){
        userService.post(user);

    }

    @PutMapping
    public UserDTO put(@RequestBody UserDTO user ){

        return userService.put(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        userService.delete(id);
        return ResponseEntity.ok().build();



    }

//    @GetMapping("/login")
//    public String login(){
//        String Pt = Jwts.builder().subject("erik").compact();
//        return Pt;


    //}

}
