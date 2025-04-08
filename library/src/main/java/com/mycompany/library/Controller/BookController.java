/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.Controller;

import com.mycompany.library.dao.BooksDAO;
import com.mycompany.library.model.Livro;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class BookController {
    public static void addBook(String title, String author, String priceStr, String yearStr){
        double price = Double.parseDouble(priceStr);
        int year = Integer.parseInt(yearStr);
        Livro myBook = new Livro(title,author,price,year);
        
        BooksDAO.addBook(myBook);
    }
    
    public static void updateBook(String idStr, String title, String author, String priceStr, String yearStr){
        int id = Integer.parseInt(idStr);
        double price = Double.parseDouble(priceStr);
        int year = Integer.parseInt(yearStr);
        Livro myBook = new Livro(title,author,price,year);
        myBook.setId(id);
        
        BooksDAO.updateBook(myBook);
    }
    
    public static void DeleteBook(String idStr){
        int id = Integer.parseInt(idStr);
        BooksDAO.deleteBook(id);
    }
    
}
