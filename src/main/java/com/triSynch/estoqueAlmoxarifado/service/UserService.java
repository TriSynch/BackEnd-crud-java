package com.triSynch.estoqueAlmoxarifado.service;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import com.triSynch.estoqueAlmoxarifado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll(){
        List<UserEntity> user = userRepository.findAll();
        return user.stream() .map(UserDTO::new).toList();
    }

    public void post(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }

    public UserDTO put(UserDTO user) {
        UserEntity userEntity = new UserEntity(user);
        return new UserDTO(userRepository.save(userEntity));
    }

    public void delete(UUID id){

        Optional<UserEntity> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()){
                userRepository.delete(userOptional.get());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
       }
    }

    public UserDTO fetchById(UUID id){
        Optional<UserEntity> userEntity = userRepository.findById(id);

        return userEntity.map(UserDTO::new).orElse(null);


    }

}
