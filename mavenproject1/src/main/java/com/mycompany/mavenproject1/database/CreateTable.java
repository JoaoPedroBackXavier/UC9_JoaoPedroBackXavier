/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class CreateTable {
    public static void createTable(Connection connection){
        
        String sql = "CREATE TABLE IF NOT EXISTS books("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "title VARCHAR(100) NOT NULL,"
                   + "author VARCHAR(255) NOT NULL,"
                   + "price REAL NOT NULL,"
                   + "year INTEGER NOT NULL)";
        
        try(Statement stmt = connection.createStatement();){
            stmt.execute(sql);
            System.out.println("sucecso");
        }
        catch(SQLException erro){ System.out.println("erro: "+erro);}
        
        
    }
    
}
