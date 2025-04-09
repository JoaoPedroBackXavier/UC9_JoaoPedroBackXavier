/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.Controller;

import com.mycompany.library.dao.BooksDAO;
import com.mycompany.library.database.ConnectSQLite;
import com.mycompany.library.model.Livro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class BookController {
    
    private static ArrayList<Livro> currentBooks = new ArrayList<>();
    
    public static void addBook(String title, String author, String priceStr, String yearStr){
        double price = Double.parseDouble(priceStr);
        int year = Integer.parseInt(yearStr);
        Livro myBook = new Livro(title,author,price,year);
        
        BooksDAO.addBook(myBook);
    }
    
    public static void updateBook(int id, String title, String author, String priceStr, String yearStr){
        double price = Double.parseDouble(priceStr);
        int year = Integer.parseInt(yearStr);
        Livro myBook = new Livro(title,author,price,year);
        myBook.setId(id);
        
        BooksDAO.updateBook(myBook);
    }
    
    public static void DeleteBook(int id){
        BooksDAO.deleteBook(id);
    }
    
    public static Livro getBookByIndex(int index){
        if (index >= 0 && index < currentBooks.size()){
            return currentBooks.get(index);
        }
        return null;
    }
    
    public static ArrayList<String> loadBooks(){
        
        ArrayList<String> formatedList = new ArrayList<>();
        currentBooks = BooksDAO.findBooks();
        
        for (Livro book:currentBooks){
            String details = "ID: " + book.getId() + " | "
                           + "Title: "+book.getTitle()+" | "
                           + "Author: "+book.getAuthor()+" | "
                           + "Price: "+book.getPrice()+" | "
                           + "Year: "+book.getYear()+" | ";
            formatedList.add(details);
        }
        return formatedList;
        
    }
    
}
