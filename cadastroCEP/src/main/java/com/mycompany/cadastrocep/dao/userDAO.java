/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrocep.dao;

import com.mycompany.cadastrocep.dataBase.ConnectSQL;
import static com.mycompany.cadastrocep.dataBase.ConnectSQL.connect;
import com.mycompany.cadastrocep.model.UserModel;
import com.mycompany.cadastrocep.service.ViaCepService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class userDAO {
    
    
    public static boolean registerUser(UserModel user) {
    String sql = "INSERT INTO users (userName, password, cep, estado, cidade, rua) VALUES (?, ?, ?, ?, ?, ?)";
    String psswordStr = new String(user.getPassword());
    String senhaHash = BCrypt.hashpw(psswordStr, BCrypt.gensalt());
        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, senhaHash);
            stmt.setInt(3, user.getCep());
            stmt.setString(4, user.getEstado());
            stmt.setString(5, user.getCidade());
            stmt.setString(6, user.getRua());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
    public static boolean deleteUser(String name) {
    String sql = "DELETE FROM users WHERE userName = ?";

        try (Connection conn = ConnectSQL.connect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    
    public static boolean editUser(UserModel user){
    String sql = "UPDATE users SET userName = ?,password = ?,cep = ?, estado = ?, cidade = ?, rua = ? WHERE id = ?";
    String psswordStr = new String(user.getPassword());
    String senhaHash = BCrypt.hashpw(psswordStr, BCrypt.gensalt());
    try (Connection conn = connect(); 
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, user.getUserName());
        stmt.setString(2, senhaHash);
        stmt.setInt(3, user.getCep());
        stmt.setString(4, user.getEstado());
        stmt.setString(5, user.getCidade());   
        stmt.setString(6, user.getRua());
        stmt.setInt(5, user.getId());
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    
    public static UserModel validarUsuario(String userName, String senhaDigitada){
    String sql = "SELECT * FROM users WHERE userName = ?";

    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String senhaCriptografada = rs.getString("password");

            // Compara a senha digitada com o hash armazenado no banco
            if (BCrypt.checkpw(senhaDigitada, senhaCriptografada)) {
                UserModel user = new UserModel(
                    rs.getString("userName"),
                    senhaCriptografada, // ou senhaDigitada se preferir manter a original
                    rs.getInt("cep"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getString("rua")
                );
                user.setId(rs.getInt("id"));
                return user;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Usuário não encontrado ou senha incorreta
}
    

    
}
