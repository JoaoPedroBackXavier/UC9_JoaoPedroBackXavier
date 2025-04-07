/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.model.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class BooksDAO {
    
    public static void addBook(Connection connection, Livro livro){
        String sql = "INSERT INTO books(title,author,price,year) VALUES (?,?,?,?)";
        
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
    
    public static void updateBook(Connection connection, int id, String title, String author, Double price, int year){
        String sql = "UPDATE books "
                   + "SET title = ?,"
                   + "author = ?,"
                   + "price = ?,"
                   + "year = ?,"
                   + "WHERE id = ?";
        
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, year);
            pstmt.setInt(5, id);
            
            int rowsUpdated = pstmt.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("book found");
            }else{
                System.out.println("book id not found, select a valid id");    
            }
            
        }catch( SQLException erro){System.out.println("erro: "+erro);}
    }
    
    public static void deleteBook(Connection connection, int id){
        String sql = "DELETE books WHERE id = ?";
        
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
    
    public static String[] findBook(Connection connection, int id){
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
}
