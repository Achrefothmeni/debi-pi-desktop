/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;

import java.util.ArrayList;

/**
 *
 * @author syrina
 */
public class LivraisonCommande {
    
    private int id;
    private int livraisonId;
    private int commandeId;    

    public LivraisonCommande(int livraisonId, int commandeId) {
        this.livraisonId = livraisonId;
        this.commandeId = commandeId;
    }

    public LivraisonCommande() {
    }

    public int getId() {
        return id;
    }

    public int getLivraisonId() {
        return livraisonId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLivraisonId(int livraisonId) {
        this.livraisonId = livraisonId;
    }

    public void setCommandeId(int CommandeId) {
        this.commandeId = CommandeId;
    }
    
    
}
