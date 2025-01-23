package com.triSynch.estoqueAlmoxarifado.dto;

import com.triSynch.estoqueAlmoxarifado.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {


    private Long id;

    private String nome;

    private String nome_de_usuario;

    private String setor;

    private String cargo;

    private String email;

    private String senhaHash;

    public UsuarioDTO(UsuarioEntity usuario){

        BeanUtils.copyProperties(usuario, this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_de_usuario() {
        return nome_de_usuario;
    }

    public void setNome_de_usuario(String nome_de_usuario) {
        this.nome_de_usuario = nome_de_usuario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
}
