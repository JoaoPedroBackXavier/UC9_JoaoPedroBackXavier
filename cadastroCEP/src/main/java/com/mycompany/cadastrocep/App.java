/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastrocep;

import com.mycompany.cadastrocep.dataBase.ConnectSQL;
import com.mycompany.cadastrocep.view.Login;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class App {

    public static void main(String[] args) {
        ConnectSQL.connect();
        new Login().setVisible(true);
    }
    
    
}
