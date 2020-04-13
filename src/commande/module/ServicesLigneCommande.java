/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author dali
 */
public class ServicesLigneCommande {
    
    
    Connection c = ConnexionDB.getInstance().getCnx();
    
    public List<Tproduit> afficher(){
           List<Tproduit> list = new ArrayList<Tproduit>();

        
        try 
        {
            PreparedStatement pt = c.prepareStatement("select id_article,name,price,quantity,description,label from article ");
                                                                                                           
           // pt.setInt(1, id_Emetteur);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next())
            {
                //System.out.println("Offre : \nType : "+rs.getString(2)+"\nEntreprise : "+rs.getString(3)+"\nDomaine : "+rs.getString(4)+"\nPoste : "+rs.getString(5)+"\nRequis : "+rs.getString(6)+"\nDescription : "+rs.getString(7)+"\nLe : "+rs.getString(8)+"\nEtat : "+rs.getString(9)+"\nA : "+rs.getString(10)+" "+rs.getString(11)+"\n"); //ordre fel table
                Tproduit p = new Tproduit(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));
                list.add(p);
            }
           
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesCommande.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return list;
    }
    
      public void ajouterLigneCommande(LigneCommande p){ 
        try 
        { 
            if(p.getQuantite()<=215) {
                 
            Statement st = c.createStatement();
            String req = "insert into lignecommande values("+p.getId()+","+p.getId_produit()+","+p.getId_commande()+","+p.getSomme()+","+p.getQuantite()+")";
            st.executeUpdate(req);
             
                
            }
            else
            {
                 showMessageDialog(null, "le stock est limiter");
            }
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesLigneCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*   public void modifierQ(int quantite){
        try 
        {
            PreparedStatement pt = c.prepareStatement("insert into  lignecommande  quantite ");
         
            pt.setInt(1,quantite);
        
            pt.executeUpdate();  
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesLigneCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
      
        public List<LigneCommande> afficherLC(){
        
        List<LigneCommande> list = new ArrayList<LigneCommande>();
        
        try 
        {
            PreparedStatement pt = c.prepareStatement("select id, prix_total,quntite ,article.name from lignecommande INNER JOIN article ON lignecommande.id_produit = article.id_article ");
            //pt.setInt(1, id_Emetteur);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Offre : \nType : "+rs.getInt(1)+"\nEntreprise : "+rs.getInt(2)+"\nDomaine : "+rs.getInt(3)+"\nnom : "+rs.getString(4)+"\n"); //ordre fel table
                LigneCommande o = new LigneCommande(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
                list.add(o);
            }
           
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicesLigneCommande.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return list;
    }
}
