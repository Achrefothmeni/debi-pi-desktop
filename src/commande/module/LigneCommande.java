/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;

/**
 *
 * @author dali
 */
public class LigneCommande {
    
    

    private int id,id_produit,id_commande,quantite,somme;
    private String nom_artcile;

    public LigneCommande() {
    }

    public LigneCommande( int id_produit, int id_commande,int somme,int quantite) {
      //  this.id = id;
        this.id_produit = id_produit;
        this.id_commande = id_commande;
        this.quantite = quantite;
        this.somme=somme;
    }

    public int getId() {
        return id;
    }

    public String getNom_artcile() {
        return nom_artcile;
    }

    public void setNom_artcile(String nom_artcile) {
        this.nom_artcile = nom_artcile;
    }

    
    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "id=" + id + ", id_produit=" + id_produit + ", id_commande=" + id_commande + ", quantite=" + quantite + ", somme=" + somme + ", nom_artcile=" + nom_artcile + '}';
    }

  

    public LigneCommande(int id, int somme,int quantite, String nom_artcile) {
        this.id=id;
        this.quantite = quantite;
        this.somme = somme;
        this.nom_artcile = nom_artcile;
    }

    

    
    
   
    
}
