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
public class TarefasDAO {
    
    
    public boolean registerTask(Task task) {
    String sql = "INSERT INTO tarefas (titulo,descricao,data_vencimento) VALUES (?, ?, ?)";

        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getExpire_date());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
    public boolean deleteTask(int id) {
    String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Task> listTasks() {
    List<Task> tasks = new ArrayList<>();
    String sql = "SELECT * FROM usuarios ORDER BY id DESC";
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
    
    public boolean editTask(int id,String title, String description, String expireDate){
    String sql = "UPDATE tasks SET description = ?,title = ?,expireDate = ?, state = 'pendente'  WHERE id = ?";

    try (Connection conn = connect(); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, description);
        stmt.setString(2, title);
        stmt.setString(3, title);
        stmt.setInt(4, id);        
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
}
