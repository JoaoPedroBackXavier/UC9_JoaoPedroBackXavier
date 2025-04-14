/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.dao;

import com.mycompany.library.database.ConnectSQLite;
import com.mycompany.library.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class BooksDAO {

    
    public static void addBook( Book livro){
        String sql = "INSERT INTO books(title,author,price,year) VALUES (?,?,?,?)";
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            
            pstmt.setString(1, livro.getTitle());
            pstmt.setString(2, livro.getAuthor());
            pstmt.setDouble(3, livro.getPrice());
            pstmt.setInt(4, livro.getYear());
            
            pstmt.executeUpdate();    
        
            System.out.println("livro adicionado");
        }catch(Exception erro){
            System.out.println("erro: "+erro.getMessage());
        }
        
    }
    
    public static void updateBook(Book meuLivro){
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        String sql = "UPDATE books "
                   + "SET title = ?,"
                   + "author = ?,"
                   + "price = ?,"
                   + "year = ?"
                   + "WHERE id = ?";
        
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, meuLivro.getTitle());
            pstmt.setString(2, meuLivro.getAuthor());
            pstmt.setDouble(3, meuLivro.getPrice());
            pstmt.setInt(4, meuLivro.getYear());
            pstmt.setInt(5, meuLivro.getId());
            
            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("book found");
            }else{
                System.out.println("book id not found, select a valid id");    
            }
            
        }catch( SQLException erro){System.out.println("erro: "+erro);}
    }
    
    public static void deleteBook(int id){
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        String sql = "DELETE FROM books WHERE id = ?";
        
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            
            if(rowsDeleted > 0){
                System.out.println("id found, bok deleted");
            }else{
                System.out.println("id not found, bok not deleted");    
            }
        }catch( SQLException erro){System.out.println("erro: "+erro);}
        
    }
    
    public static String[] findBook(int id){
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        String sql = "SELECT * FROM books WHERE id = ?";
        String[] info = new String[4];
        
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                info[0] = rs.getString("title");
                info[1] = rs.getString("author");
                info[2] = rs.getString("price");
                info[3] = rs.getString("year");
                
            }
        }catch( SQLException erro){System.out.println("erro: "+erro);}
        return info;
    }
    
    public static ArrayList<Book> findBooks(){
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        String sql = "SELECT * FROM books";
        ArrayList<Book> info = new ArrayList<>();
        
        try(Statement stmt = connection .createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Book myBook = new Book(
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price"),
                    rs.getInt("year")
                );
                myBook.setId(rs.getInt("id"));
                info.add(myBook);
            }
        }catch(SQLException erro){
            System.out.println("erro: "+erro);
        }
        return info;
    }
}
