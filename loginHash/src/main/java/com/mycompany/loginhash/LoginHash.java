/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginhash;

import com.mycompany.loginhash.dao.UsuarioDAO;
import com.mycompany.loginhash.database.ConnectionSQL;
import com.mycompany.loginhash.model.Usuario;
import com.mycompany.loginhash.view.TelaLogin;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class LoginHash {

    public static void main(String[] args) {
        new TelaLogin().setVisible(true);
    }
}
