/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;

import java.io.IOException;
import livraison.module.LivraisonCommande;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import user.module.UserLoginController;

/**
 *
 * @author syrina
 */
public class Livraison {
    private int id;
    private String statut;
    private Date dateDepart;
    private Date dateArrivee;
    private int livreurdId;
    private String flotte;
    private Button action;
    private ArrayList <LivraisonCommande> listecommandes =new ArrayList();

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    
    

    public Livraison(Date dateDepart, int livreurdId, String flotte) {
        this.statut = "En attente";
        this.dateDepart = dateDepart;
        this.livreurdId = livreurdId;
        this.flotte = flotte;
        this.action = new Button("Voir");
        //this.action.setText("Voir");
        /*this.action.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
        Parent home;
        //home = FXMLLoader.load(getClass().getResource("/livraison/module/modifier_livraison.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/livraison/module/modifier_livraison.fxml"));
        ModifierLivraisonController controller = loader.getController();
        controller.livraisonId = id;
        Scene homescene = new Scene(loader.getRoot());
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(homescene);
        app_stage.show();
            }
        });*/
    }

    public Livraison() {
        this.action = new Button("voir");
        /*this.action.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/livraison/module/modifier_livraison.fxml"));
        ModifierLivraisonController controller = loader.getController();
        controller.livraisonId = id;
                try {
                    stage.setScene(new Scene( loader.load()));
                    loader.<ModifierLivraisonController>getController();
                    controller.livraisonId=id;
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(Livraison.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });*/
    }
   

    public int getId() {
        return id;
    }


    public String getStatut() {
        return statut;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public int getLivreurdId() {
        return livreurdId;
    }

    public String getFlotte() {
        return flotte;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setLivreurdId(int livreurdId) {
        this.livreurdId = livreurdId;
    }

    public void setFlotte(String flotte) {
        this.flotte = flotte;
    }

    public ArrayList<LivraisonCommande> getListecommandes() {
        return listecommandes;
    }

    public void setListecommandes(ArrayList<LivraisonCommande> listecommandes) {
        this.listecommandes = listecommandes;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", statut=" + statut + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", livreurdId=" + livreurdId + ", flotte=" + flotte + ", listecommandes=" + listecommandes + '}';
    }

}
