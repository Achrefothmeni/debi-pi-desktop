/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

/**
 *
 * @author syrina
 */
public class ModifierLivraisonController implements Initializable {

    @FXML
    Text text_id;
    
    @FXML
    Text text_dep;
    
    @FXML
    DatePicker text_arr;
    
    @FXML
    Text text_livid;
    
    @FXML
    Text text_flotte;
    
    @FXML
    ComboBox<String> combo_stat;
    
    
     @FXML
    public void modifier(ActionEvent event){
    
        java.sql.Date arr = java.sql.Date.valueOf(text_arr.getValue());
        String selectedStatus = combo_stat.getSelectionModel().getSelectedItem().toString();
        LivraisonDAO livDao = new LivraisonDAO();
        Livraison livraison = livDao.findOne(Integer.parseInt(text_id.getText()));
        livraison.setDateArrivee(arr);
        livraison.setStatut(selectedStatus);
        livDao.update(livraison);
    }
    
    void initData(Livraison liv) {
    
       
        text_id.setText(String.valueOf(liv.getId()));
        text_dep.setText(liv.getDateDepart().toString());
        text_livid.setText(liv.getDateDepart().toString());
        text_flotte.setText(String.valueOf(liv.getFlotte()));
  }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combo_stat.getItems().clear();
        combo_stat.getItems().addAll("En cours","Terminée","Annulée");
    }
    
}
