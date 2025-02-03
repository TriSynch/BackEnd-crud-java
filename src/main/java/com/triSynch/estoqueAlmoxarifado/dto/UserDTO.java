package com.triSynch.estoqueAlmoxarifado.dto;

import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserDTO {


    private Long id;
    private String name;
    private String username;
    private String sector;
    private String email;
    private String passwordHash;
    private String confirmPassword;

    public UserDTO(){}
    public UserDTO(UserEntity user){

        BeanUtils.copyProperties(user, this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
