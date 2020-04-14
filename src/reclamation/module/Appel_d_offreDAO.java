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
public class Appel_d_offreDAO {
        
    Connection connection = DBConnection.getInstance().getConnexion();
    
    public void add(Appel_d_Offre app_off)throws SQLException {
        String  query  = "INSERT INTO appel_d_offre (status) VALUES ('non Traité')";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate(); 
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Appel_d_Offre> show()throws SQLException {
            List<Appel_d_Offre> app_off = new ArrayList<>();
            String query = "SELECT * FROM appel_d_offre";
            Statement stm;
            try {
                stm = connection.createStatement();
                ResultSet result = stm.executeQuery(query);
                
            while(result.next()){
                Appel_d_Offre p = new Appel_d_Offre(result.getInt(1), result.getString("status"));
                app_off.add(p);
            }

            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
            return app_off;
        }
    public void update(Appel_d_Offre app_off){
            String  query  = "UPDATE appel_d_offre SET status = 'Traité'";
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(query);
                ps.execute();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }   
        }
        
    
}
