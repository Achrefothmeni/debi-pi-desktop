/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;


import static commande.module.JavaMail.sendMail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author dali
 */
public class ServicesCommande {
    
     Connection c = ConnexionDB.getInstance().getCnx();
    
    
   public void traiterReclamation(int id){
        try 
        {
            PreparedStatement pt = c.prepareStatement("update commande set status=?  where id=?");
            //pt.setBoolean(1, true); //ordre fel requete
            pt.setString(1,"Validé");
            pt.setInt(2,id);
            pt.executeUpdate();  
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
    
     public void ajouterCommande(Commande p) {
        try 
        {
            Statement st = c.createStatement();
            String req = "insert into commande values("+p.getId()+",'"+p.getDate()+"',"+p.getId_usr()+","+p.getSomme()+",'"+p.getAdresse()+"','"+p.getDateM()+"','"+p.getStatus()+"')";
            st.executeUpdate(req);
            try{
             sendMail("mohamedali.mamni@esprit.tn","Facture :","Facture");} catch (Exception ex) {
                Logger.getLogger(ServicesCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   /* public void modifierCommande(Commande p, String type,String description){
        try 
        {
            PreparedStatement pt = c.prepareStatement("update reclamation set selecteur=?,description=?  where idRecl=?");
            pt.setString(1, type); //ordre fel requete
             pt.setString(2, description);
            pt.setInt(3,p.getIdRecl());
            pt.executeUpdate();  
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
  
    
     public List<Commande> afficher(){
           List<Commande> list = new ArrayList<Commande>();

        
        try 
        {
            PreparedStatement pt = c.prepareStatement("select id,dateCommande,id_user,summe,adresse,date_max,status from commande ");
                                                                                                           
           // pt.setInt(1, id_Emetteur);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next())
            {
                //System.out.println("Offre : \nType : "+rs.getString(2)+"\nEntreprise : "+rs.getString(3)+"\nDomaine : "+rs.getString(4)+"\nPoste : "+rs.getString(5)+"\nRequis : "+rs.getString(6)+"\nDescription : "+rs.getString(7)+"\nLe : "+rs.getString(8)+"\nEtat : "+rs.getString(9)+"\nA : "+rs.getString(10)+" "+rs.getString(11)+"\n"); //ordre fel table
                Commande o = new Commande(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
                list.add(o);
            }
           
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesCommande.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return list;
    }
    
   
    
    public void supprimerPersonne(Commande p){   
        try 
        {
            PreparedStatement pt = c.prepareStatement("delete from commande where id=?");
            pt.setInt(1,p.getId());
            pt.executeUpdate();     
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
   
   
    
    
    
    
    
   
}        
    

