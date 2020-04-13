/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;

import com.sun.prism.impl.Disposer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author dali
 */
public class ProduitController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtquantite;

    @FXML
    private void affichage(ActionEvent event) throws IOException {
        
          AnchorPane pane = FXMLLoader.load(getClass().getResource("Afficherlignecommande.fxml"));
         root.getChildren().setAll(pane);
        
        
        
    }
    
    //public static Commande gr ;
  private class ButtonCell extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("valider ");
       
        ButtonCell(){
            
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                	Tproduit  Tproduit= (Tproduit) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                       //Commande  Commande= (Commande) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                	//remove selected item from the table list
                	//olist.remove(currentOffre);
                        
                        //remove from DB
                      //  srv.supprimerReclamationG(currentOffre);
                     // int quantite = txtquantite.getText();
                     // int jml = jTextField3.getText();
                      int quantite = Integer.parseInt(txtquantite.getText());
                      
                      
                         ServicesLigneCommande srv  = new ServicesLigneCommande();
                       // Tproduit Tproduit= new Tproduit();
                       // Commande Commande = new Commande();
                    //  LigneCommande LigneCommande=new LigneCommande();
                    int s=Tproduit.getPrice();
                    int somme=s*quantite;
                    
                        LigneCommande r =new LigneCommande(Tproduit.getId_artcle(),19,somme,quantite);
                        srv.ajouterLigneCommande(r);
                     
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
            setGraphic(cellButton);
            }
            else{
            setGraphic(null);
            }
        }
    }
    @FXML
    private TableView<Tproduit> tabP = new TableView<Tproduit>();
    
  //Id du chasseur connecté
  
     ServicesLigneCommande srv = new ServicesLigneCommande();
        ObservableList<Tproduit> olist = FXCollections.observableArrayList(srv.afficher());
   

    /**
     * Initializes the controller class.
     */
        //srv.afficherGroupeReclamation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tabP.setEditable(true);
        
      
       TableColumn<Tproduit, Integer> idCol //
              = new TableColumn<Tproduit, Integer>("id article"); 
        
        TableColumn<Tproduit, String> nomCol //
              = new TableColumn<Tproduit, String>("nom");
        
        
        TableColumn<Tproduit, Integer> prixCol //
              = new TableColumn<Tproduit, Integer>("prix");
        
        
        TableColumn<Tproduit, Integer> quantiteCol //
              = new TableColumn<Tproduit, Integer>("quantite");
        
         TableColumn<Tproduit, String> descriptionCol //
              = new TableColumn<Tproduit, String>("description");
         
        TableColumn<Tproduit, String> labelCol //
              = new TableColumn<Tproduit, String>("label");
     
        
     
              TableColumn actionCol = new TableColumn<>("Valider");
            

         
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_artcle"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantiteCol.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        labelCol.setCellValueFactory(new PropertyValueFactory<>("label"));
      
     actionCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
 
        });
     
      
        
    
       // idCol.setVisible(false);
        idCol.setMinWidth(100);
        nomCol.setMinWidth(100);
        prixCol.setMinWidth(100);
        quantiteCol.setMinWidth(100);
        descriptionCol.setMinWidth(100);
        labelCol.setMinWidth(100);
       // descriptiongCol.setMinWidth(100);
          actionCol.setMinWidth(100);
                

      
     
        
        tabP.getColumns().addAll(idCol,nomCol,prixCol,quantiteCol,descriptionCol,labelCol,actionCol);
        
        tabP.setItems(olist);
        
        /*quantiteCol.setCellFactory(TextFieldTableCell.<Tproduit> forTableColumn());
        quantiteCol.setOnEditCommit((CellEditEvent<Tproduit, Integer> event) -> {
            TablePosition<Tproduit, Integer> pos = event.getTablePosition();
 
            Integer newDescription = event.getNewValue();
         int quantite = Integer.parseInt(txtquantite.getText());
 
            int row = pos.getRow();
            Tproduit o = event.getTableView().getItems().get(row);
 
            o.setQuantite(newDescription);
            
            srv.modifierQ();
        });*/
        
        
               //Adding the Button to the cell
               
      
      
           actionCol.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCell();
            }
        
        });
  
      
    }

     
         
           
    
    }


