package com.triSynch.estoqueAlmoxarifado.service;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import com.triSynch.estoqueAlmoxarifado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserDTO register(UserDTO user) {
        //verificar se o e-mail esta em registrado
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail is already registered.");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is already registered");
        }


        String hashedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);

        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
        return new UserDTO(userEntity);
    }
    public UserDTO login(String username, String password){
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        if (userEntity.isPresent()){

            if (passwordEncoder.matches(password, userEntity.get().getPasswordHash())) {
                return new UserDTO(userEntity.get());
            }

        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials.");


    }
}
