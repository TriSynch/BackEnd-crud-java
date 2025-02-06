package com.triSynch.estoqueAlmoxarifado.service;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import com.triSynch.estoqueAlmoxarifado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;



    public UserDTO register(UserDTO user){
        UserEntity userEntity = new UserEntity (user);
        userRepository.save(userEntity);
        return new UserDTO(userEntity);

    }
    public UserDTO login(String username, String password){
        Optional<UserEntity> userEntity = userRepository.findByUsernameAndPasswordHash( username, password);

        return userEntity.map(UserDTO::new).orElse(null);
    }
}
