/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;

import com.sun.prism.impl.Disposer;
import com.sun.prism.impl.Disposer.Record;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author dali
 */
public class AjoutCommandeController implements Initializable {

  //  @FXML
   // private AnchorPane root;

  //  @FXML
   // private void retour(ActionEvent event) throws IOException {
        
       //  AnchorPane pane = FXMLLoader.load(getClass().getResource("AjouterCommande.fxml"));
      //   root.getChildren().setAll(pane);
  //  }
    
    
    
 
  
@FXML
    private TableView<Commande> tabC = new TableView<Commande>();
    
  //Id du chasseur connecté
  
     ServicesCommande srv = new ServicesCommande();
        ObservableList<Commande> olist = FXCollections.observableArrayList(srv.afficher());

    /**
     * Initializes the controller class.
     */
        //srv.afficherGroupeReclamation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tabC.setEditable(true);
        
      
       TableColumn<Commande, Integer> idCol //
              = new TableColumn<Commande, Integer>("id"); 
        
        TableColumn<Commande, String> dateCol //
              = new TableColumn<Commande, String>("date de la commande");
        
        
        TableColumn<Commande, Integer> idusrCol //
              = new TableColumn<Commande, Integer>("id utilisateur");
        
        
        TableColumn<Commande, Integer> sommeCol //
              = new TableColumn<Commande, Integer>("somme");
        
         TableColumn<Commande, String> titreCol //
              = new TableColumn<Commande, String>("adresse");
         
        TableColumn<Commande, String> descriptionCol //
              = new TableColumn<Commande, String>("date max");
        
        TableColumn<Commande, String> descriptiongCol //
              = new TableColumn<Commande, String>("status");
        
     
          

         
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        idusrCol.setCellValueFactory(new PropertyValueFactory<>("id_usr"));
        sommeCol.setCellValueFactory(new PropertyValueFactory<>("somme"));
        titreCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("dateM"));
        descriptiongCol.setCellValueFactory(new PropertyValueFactory<>("status"));
 
      
        
    
        idCol.setVisible(false);
        dateCol.setMinWidth(200);
        idusrCol.setMinWidth(150);
        sommeCol.setMinWidth(100);
        titreCol.setMinWidth(200);
        descriptionCol.setMinWidth(200);
        descriptiongCol.setMinWidth(100);
       
                

      
     
        
        tabC.getColumns().addAll(idCol,dateCol,idusrCol,sommeCol,titreCol,descriptionCol,descriptiongCol);
        
        tabC.setItems(olist);
               //Adding the Button to the cell
      
          
        
           
    }
         
           
    
    }


