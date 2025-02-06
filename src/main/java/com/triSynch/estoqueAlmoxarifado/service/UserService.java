package com.triSynch.estoqueAlmoxarifado.service;

import com.triSynch.estoqueAlmoxarifado.dto.UserDTO;
import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import com.triSynch.estoqueAlmoxarifado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public void delete(Long id){
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public UserDTO fetchById(Long id){
        return new UserDTO(userRepository.findById(id).get());

    }

}
