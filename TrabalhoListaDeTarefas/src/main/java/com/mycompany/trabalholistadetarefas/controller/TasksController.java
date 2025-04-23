/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalholistadetarefas.controller;

import com.mycompany.trabalholistadetarefas.dao.TasksDAO;
import com.mycompany.trabalholistadetarefas.model.Task;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class TasksController {
    
    public static boolean registerTask(String title, String description, String expireDAte){
        return TasksDAO.registerTask(title,description,expireDAte);
    }
    public static Task buscarTaskPorIdSelected(int idSelected) {
        return TasksDAO.buscarTaskPorIdSelected(idSelected);
    }
    public static boolean deleteTask(String title) {
        return TasksDAO.deleteTask(title);
    }
    
}
