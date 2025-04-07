/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.dao.BooksDAO;
import com.mycompany.mavenproject1.database.ConnectSQLite;
import com.mycompany.mavenproject1.database.CreateTable;
import com.mycompany.mavenproject1.model.Livro;
import java.sql.Connection;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        CreateTable.createTable(connection);
        
        Livro livro1 = new Livro("o senhor do anel", "kidBengas", 69.69, 1969);
        
        //BooksDAO.addBook(connection, livro1);
        
    }
}
