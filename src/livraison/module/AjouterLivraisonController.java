/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import user.module.User;
import user.module.UserDAO;

/**
 *
 * @author syrina
 */
public class AjouterLivraisonController implements Initializable {
    
    @FXML
    DatePicker date_dep;
    
    @FXML
    ComboBox<String> liv_id ;

    @FXML
    ComboBox<String> flotte_id;


  
  UserDAO userdao = new UserDAO();
  
    @FXML
    public void ajouter(ActionEvent event){
        
        java.sql.Date dep = java.sql.Date.valueOf(date_dep.getValue());
        
        System.out.println(dep);
        Livraison livraison = new Livraison();
        livraison.setDateDepart(dep);
        User liv = userdao.findOne(liv_id.getSelectionModel().getSelectedItem().toString());
        //livraison.setLivreurdId(liv.getId());
        livraison.setStatut("En attente");
        livraison.setFlotte("123TUN4352");
        LivraisonDAO livraisonDAO = new LivraisonDAO();     
        livraisonDAO.save(livraison);
        
    }
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ArrayList<User> users = userdao.findAll();
        ArrayList<User> livreurs = new ArrayList<>();
        for(User liv : users){
            if(liv.getRoles().equals("a:1:{i:0;s:21:"+'"'+"ROLE_DELIVERY_MANAGER"+'"'+";}")){
                livreurs.add(liv);
            }
        }
        for(User liv: livreurs){
            liv_id.getItems().add(liv.getUsername());
        }
        
        
        
    
    }
     
}
