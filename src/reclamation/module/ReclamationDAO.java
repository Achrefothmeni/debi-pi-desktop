/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation.module;

import debo.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dhia
 */
public class ReclamationDAO {
    
        Connection connection = DBConnection.getInstance().getConnexion();

        public void add(Reclamation reclamation)throws SQLException {
            String  query  = "INSERT INTO reclamation (message, type) VALUES (?,?)";
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(query);
                ps.setString (2, reclamation.getType());
                ps.setString (1, reclamation.getMessage());
                ps.executeUpdate(); 
            }catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        public List<Reclamation> show()throws SQLException {
            List<Reclamation> reclamations = new ArrayList<>();
            String query = "SELECT * FROM reclamation";
            Statement stm;
            try {
                stm = connection.createStatement();
                ResultSet result = stm.executeQuery(query);
                
            while(result.next()){
                Reclamation p = new Reclamation(result.getInt(1), result.getString("message"), result.getString("type"), result.getString("status"));
                reclamations.add(p);
            }

            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
            return reclamations;
        }
        
        public void update(Reclamation reclamation){
            String  query  = "UPDATE reclamation SET status = 'Traitée'";
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(query);
                ps.execute();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }   
        }
    
}
