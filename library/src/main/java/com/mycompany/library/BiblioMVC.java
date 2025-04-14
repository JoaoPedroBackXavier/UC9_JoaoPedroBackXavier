/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library;

import com.mycompany.library.database.ConnectSQLite;
import com.mycompany.library.database.CreateTable;
import com.mycompany.library.view.TelaLogin;
import java.sql.Connection;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class BiblioMVC {

    public static void main(String[] args) {
        
        new TelaLogin().setVisible(true);
        
    }
}
