/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginhash;

import com.mycompany.loginhash.dao.UsuarioDao;
import com.mycompany.loginhash.database.ConnectionSQL;
import com.mycompany.loginhash.model.Usuario;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class LoginHash {

    public static void main(String[] args) {
        ConnectionSQL.conectar();
        
        UsuarioDao usuariodao = new UsuarioDao();
        
        Usuario usuario = new Usuario("ana@gmail.com","pqmzijgi");
        
//        usuariodao.registrarUsuario(usuario);
        
//        System.out.println(usuariodao.validarLogin(usuario));

//        System.out.println(usuariodao.buscarUsuarioPorEmail("jaozitos@gmaile"));
    }
}
