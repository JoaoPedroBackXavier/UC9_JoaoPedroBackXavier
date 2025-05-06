/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrocep.model;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class UserModel {
    String userName;
    String password;    
    int id;
    
    int cep;   
    String estado;    
    String cidade;
    String rua;

    public UserModel(String userName, String password, int cep, String estado, String cidade, String rua) {
        this.userName = userName;
        this.password = password;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    
}
