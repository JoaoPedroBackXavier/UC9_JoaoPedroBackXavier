/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalholistadetarefas.dao;

import com.mycompany.TrabalhoListaDeTarefas.database.ConnectSQL;
import static com.mycompany.TrabalhoListaDeTarefas.database.ConnectSQL.connect;
import com.mycompany.trabalholistadetarefas.model.Task;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class TasksDAO {
    
    
    public static boolean registerTask(String title, String description, String expireDAte) {
    String sql = "INSERT INTO tasks (title,description,expire_date) VALUES (?, ?, ?)";

        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, expireDAte);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
    public static boolean deleteTask(String title) {
    String sql = "DELETE FROM tasks WHERE title = ?";

        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Task> listTasks() {
    List<Task> tasks = new ArrayList<>();
    String sql = "SELECT * FROM tasks ORDER BY id ASC";
        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(rs.getString("title"),rs.getString("description"),rs.getString("expire_date")); // senha não exibida
                task.setId(rs.getInt("id"));
                task.setExpire_date(rs.getString("expire_date"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
        }
    
    public static boolean editTask(int id,String title, String description, String expireDate, String state){
    String sql = "UPDATE tasks SET description = ?,title = ?,expire_date = ?, state = ?  WHERE id = ?";

    try (Connection conn = connect(); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, description);
        stmt.setString(2, title);
        stmt.setString(3, expireDate);
        stmt.setString(4, state);
        stmt.setInt(5, id);        
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public static Task buscarTaskPorIdSelected(int idSelected) {
    String sql = "SELECT * FROM tasks ORDER BY id LIMIT 1 OFFSET ?";

    try (Connection conn = ConnectSQL.connect(); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, idSelected);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Task task = new Task(rs.getString("title"), rs.getString("description"), rs.getString("expire_date"));
            task.setId(Integer.parseInt(rs.getString("id")));
            task.setState(rs.getString("state"));
            return task;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
}
