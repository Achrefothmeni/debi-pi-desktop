/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import user.module.UserLoginController;

/**
 * FXML Controller class
 *
 * @author syrina
 */
public class LivraisonController implements Initializable {
    @FXML
    private TableView<Livraison> table;
    @FXML
    private TableColumn<Livraison, Integer> col_id;
    
    @FXML
    private TableColumn<Livraison, Date> col_dep;
    
    @FXML
    private TableColumn<Livraison,Date> col_arr;
    
    @FXML
    private TableColumn<Livraison, String> col_stat;
    
    @FXML
    private TableColumn<Livraison, Integer> col_livid;
    
    @FXML
    private TableColumn<Livraison, String> col_flotte;
    
    private TableColumn<Livraison, String> actionCol = new TableColumn("Action");
    
    ObservableList<Livraison> livraisons;
    @FXML
    private Button ajouter;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        table.getColumns().add(actionCol);
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_dep.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
        col_arr.setCellValueFactory(new PropertyValueFactory<>("dateArrivee"));
        col_stat.setCellValueFactory(new PropertyValueFactory<>("statut"));
        col_livid.setCellValueFactory(new PropertyValueFactory<>("livreurdId"));
        col_flotte.setCellValueFactory(new PropertyValueFactory<>("flotte"));
        actionCol.setCellValueFactory(new PropertyValueFactory<Livraison, String>("action"));  
        LivraisonDAO livraisonDAO = new LivraisonDAO();
        ArrayList<Livraison> livraisonsList = livraisonDAO.findAll(); 
        for(Livraison liv: livraisonsList){
            liv.getAction().setOnAction(e -> {
                
                Stage stage = new Stage();
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/livraison/module/modifier_livraison.fxml"));
               Parent parent;
                    try {
                        parent = (Parent) loader.load();
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.show();
                        ModifierLivraisonController controller = loader.getController();
                        controller.initData(liv);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
               
            
               
        //controller.livraisonId = liv.getId();
                //System.out.println(liv);
                //System.out.println(controller.livraisonId);
                //try {
                    //stage.setScene(new Scene( loader.load()));
                    //loader.<ModifierLivraisonController>getController();
                    //controller.livraison=liv;
                    //stage.show();
                //} catch (IOException ex) {
                  //  Logger.getLogger(Livraison.class.getName()).log(Level.SEVERE, null, ex);
                //}
            });
        }
        ObservableList<Livraison> listLiv = FXCollections.observableArrayList(livraisonsList);
        table.setItems(listLiv);
        
    };
        
    
    @FXML
    private void ajouterRedirect(ActionEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("/livraison/module/ajout_livraison.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    private void voirRedirect(ActionEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("/livraison/module/modifer_livraison.fxml"));
            Scene homescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(homescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

