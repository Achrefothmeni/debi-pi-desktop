/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.module.dao;

import debo.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.module.model.User;

/**
 *
 * @author dell
 */
public class UserDAO {
    
    Connection connection = DBConnection.getInstance().getConnexion();
    
    public void save(User user){
        String  query  = "INSERT INTO fos_user (username, username_canonical, email, email_canonical, enabled, password, roles, mat_fiscal, nom, prenom, status_livreur, numero_tel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, user.getUsername());
            preparedStmt.setString (2, user.getUsernameCanonical());
            preparedStmt.setString (3, user.getEmail());
            preparedStmt.setString (4, user.getEmailCanonical());
            preparedStmt.setInt(5, 1);
            preparedStmt.setString (6, user.getPassword());
            preparedStmt.setString (7, user.getRoles());
            preparedStmt.setString (8, user.getMatFiscal());
            preparedStmt.setString (9, user.getNom());
            preparedStmt.setString (10, user.getPrenom());
            preparedStmt.setString (11, user.getStatus());
            preparedStmt.setInt (12, user.getNumTel());
            preparedStmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        }
    
    public void update(User user){
        String  query  = "UPDATE fos_user SET username = ?, email = ?, roles = ?, mat_fiscal = ?, nom = ?, prenom = ?, numero_tel = ?";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, user.getUsername());
            preparedStmt.setString (2, user.getEmail());
            preparedStmt.setString (3, user.getRoles());
            preparedStmt.setString (4, user.getMatFiscal());
            preparedStmt.setString (5, user.getNom());
            preparedStmt.setString (6, user.getPrenom());
            preparedStmt.setInt (7, user.getNumTel());
            preparedStmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public User findOne(String username){
        String query = "SELECT * FROM fos_user WHERE username = ?";
        PreparedStatement preparedStmt;
        User user = new User();
        try{
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, username);
            ResultSet rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setMatFiscal(rs.getString("mat_fiscal"));
                user.setStatus(rs.getString("status_livreur"));
                user.setNumTel(rs.getInt("numero_tel"));
                user.setRoles(rs.getString("roles"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }
    
    public ArrayList<User> findAll(String username){
        ArrayList<User> users = new ArrayList(); 
        String query = "SELECT * FROM fos_user";
        PreparedStatement preparedStmt;
        try{
            preparedStmt = connection.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setMatFiscal(rs.getString("mat_fiscal"));
                user.setStatus(rs.getString("status_livreur"));
                user.setNumTel(rs.getInt("numero_tel"));
                user.setRoles(rs.getString("roles"));
                users.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return users;
    }
    
    public void delete(User user){
        String query = "DELETE FROM fos_user WHERE username=?";
        PreparedStatement preparedStmt;
        try{
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, user.getUsername());
            preparedStmt.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
