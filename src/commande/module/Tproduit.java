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
public class Tproduit {
    
    private int id_artcle,quantite,price;
    private String name,description,label;

    public Tproduit() {
    }

    public Tproduit(int id_artcle, String name,int price,int quantite, String description, String label) {
        this.id_artcle = id_artcle;
        this.quantite = quantite;
        this.price = price;
        this.name = name;
        this.description = description;
        this.label = label;
    }

    public int getId_artcle() {
        return id_artcle;
    }

    public void setId_artcle(int id_artcle) {
        this.id_artcle = id_artcle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Tproduit{" + "id_artcle=" + id_artcle + ", quantite=" + quantite + ", price=" + price + ", name=" + name + ", description=" + description + ", label=" + label + '}';
    }
    
    
    
    
}
