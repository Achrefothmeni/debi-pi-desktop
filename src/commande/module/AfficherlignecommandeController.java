/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author dali
 */
public class AfficherlignecommandeController implements Initializable {

  @FXML
    private TableView<LigneCommande> tabLC = new TableView<LigneCommande>();
    
  //Id du chasseur connecté
  
     ServicesLigneCommande srv = new ServicesLigneCommande();
        ObservableList<LigneCommande> olist = FXCollections.observableArrayList(srv.afficherLC());
    @FXML
    private AnchorPane root;
    @FXML
    private Button GoTOCom;

    /**
     * Initializes the controller class.
     */
        //srv.afficherGroupeReclamation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tabLC.setEditable(true);
        
      
       TableColumn<LigneCommande, Integer> idCol //
              = new TableColumn<LigneCommande, Integer>("id"); 
     
        
        
        TableColumn<LigneCommande, Integer> prixCol //
              = new TableColumn<LigneCommande, Integer>("prix");
        
        
        TableColumn<LigneCommande,Integer> quantiteCol //
              = new TableColumn<LigneCommande, Integer>("quantite");
        
           TableColumn<LigneCommande,String> nomCol //
              = new TableColumn<LigneCommande, String>("nom");
        
       // TableColumn<LigneCommande, String> nomCol //
            //  = new TableColumn<LigneCommande, String>("nom");
        
       
         
     
            
         //   TableColumn actionCol = new TableColumn<>("Supprimer");
          //  TableColumn traiterCol = new TableColumn<>("Traiter");
          //  TableColumn traiter1Col = new TableColumn<>("Traiter1");
         
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        prixCol.setCellValueFactory(new PropertyValueFactory<>("somme"));
        quantiteCol.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom_artcile"));
       
    
        
        
    
      //  idCol.setVisible(false);
        idCol.setMinWidth(100);
       
        prixCol.setMinWidth(100);
        quantiteCol.setMinWidth(100);
         nomCol.setMinWidth(100);
     
      //  actionCol.setMinWidth(100);
     
        
        tabLC.getColumns().addAll(idCol,prixCol,quantiteCol,nomCol);
        
        tabLC.setItems(olist);
               //Adding the Button to the cell
    
        
        
           
    }

    @FXML
    private void GotoCom(ActionEvent event)throws IOException { 
    
         
           AnchorPane pane = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));
         root.getChildren().setAll(pane);
    
    }

    @FXML
    private void retour(ActionEvent event)throws IOException{
        
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Produit.fxml"));
         root.getChildren().setAll(pane);
    }
 
}


