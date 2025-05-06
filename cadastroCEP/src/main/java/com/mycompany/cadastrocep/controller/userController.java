/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrocep.controller;

import com.mycompany.cadastrocep.dao.userDAO;
import com.mycompany.cadastrocep.model.UserModel;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class userController {
    public static boolean registerUser(UserModel user) {
        return userDAO.registerUser(user);
    }
    public static UserModel validarUsuario(String userName, String senha){
        return userDAO.validarUsuario(userName, senha);
    }
    public static boolean deleteUser(String name) {
        return userDAO.deleteUser(name);
    }
}
