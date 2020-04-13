/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;

import livraison.module.Livraison;
import debo.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author syrina
 */
public class LivraisonDAO {
      
    Connection connection = DBConnection.getInstance().getConnexion();
    
    public void save(Livraison livraison){
        String  query  = "INSERT INTO livraison (status, date_depart, livreur_id, flotte) VALUES (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString (1, livraison.getStatut());
            ps.setDate(2, livraison.getDateDepart());
            ps.setInt (3, livraison.getLivreurdId());
            ps.setString (4, livraison.getFlotte());
            ps.execute();
            
            query = "SELECT id FROM livraison ORDER BY id ASC";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int idLivraison = 0;
            while ( rs.next() ){
                idLivraison = rs.getInt("id");
            }
            
            for(LivraisonCommande commande : livraison.getListecommandes()){
                query  = "INSERT INTO livraison_commande (livraison_id, commande_id) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setInt (1, idLivraison);
                ps.setInt (1, commande.getCommandeId());
                ps.execute();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void update(Livraison livraison){
        String  query  = "UPDATE Livraison SET status = ?, date_arivee = ? Where id = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString (1, livraison.getStatut());
            ps.setDate(2, livraison.getDateArrivee());
            ps.setInt(3, livraison.getId());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
    
    public Livraison findOne(int id){
        String query = "SELECT * FROM Livraison WHERE id = ?";
        PreparedStatement ps;
        Livraison livraison = new Livraison();
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                livraison.setId(rs.getInt("id"));
                livraison.setStatut(rs.getString("statut"));
                livraison.setDateDepart(rs.getDate("date_depart"));
                livraison.setDateArrivee(rs.getDate("date_arrivee"));
                livraison.setLivreurdId(rs.getInt("livreur_id"));
                livraison.setFlotte(rs.getString("flotte"));
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return livraison;
    }
    
   
    public ArrayList<Livraison> findAll(){
        ArrayList<Livraison> livraisons = new ArrayList(); 
        String query = "SELECT * FROM Livraison";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                Livraison livraison = new Livraison();
                livraison.setId(rs.getInt("id"));
                livraison.setStatut(rs.getString("status"));
                livraison.setDateDepart(rs.getDate("date_depart"));
                livraison.setDateArrivee(rs.getDate("date_arivee"));
                livraison.setLivreurdId(rs.getInt("livreur_id"));
                livraison.setFlotte(rs.getString("flotte"));          
                
                livraisons.add(livraison);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return livraisons;
    }
    
}
    
 
