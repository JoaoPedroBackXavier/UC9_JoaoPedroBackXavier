/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginhash.controller;

import com.mycompany.loginhash.dao.UsuarioDAO;
import com.mycompany.loginhash.model.Usuario;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class UsuarioController {
    
   
    public static boolean registrarUsuario(String email, char[] charSenha){
        String senha = new String(charSenha);
        Usuario usuario = new Usuario(email,senha);
        UsuarioDAO usuarioDAO = new UsuarioDAO();         
        return usuarioDAO.registrarUsuario(usuario);
    }
    public static Usuario verificarUsuario(String email, char[] charSenha){
        String senha = new String(charSenha);
        Usuario usuario = new Usuario(email,senha);
        UsuarioDAO usuarioDAO = new UsuarioDAO();         
        if (usuarioDAO.validarLogin(usuario)){
            return usuario;
        }else{
            return null;
        }
    }
    public static Usuario buscarUsuarioPorEmail(String email){
        UsuarioDAO usuarioDAO = new UsuarioDAO();  
        return usuarioDAO.buscarUsuarioPorEmail(email);
    }
}
