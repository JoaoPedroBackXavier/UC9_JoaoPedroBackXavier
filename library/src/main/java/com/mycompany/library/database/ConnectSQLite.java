/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class ConnectSQLite {
    public Connection connect(){
        Connection connection = null;
        
        String url = "jdbc:sqlite:library.db";
        
        try{
            connection = DriverManager.getConnection(url);
            System.out.println("conectado com suscesso");
        }
        catch(SQLException erro){
            System.out.println("erro ao conectar: "+erro.getMessage());
        }
        return connection;
    }
    
    public void disconect(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException erro){
                System.out.println("erro ao encerrar conexao: "+erro.getMessage());
            }
        }else{
            System.out.println("conexao nao encontrada");
        }
    }
}
