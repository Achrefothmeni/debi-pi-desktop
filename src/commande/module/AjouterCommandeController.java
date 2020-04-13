/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commande.module;


import java.awt.TrayIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import doryan.windowsnotificationapi.fr.Notification;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author dali
 */
public class AjouterCommandeController implements Initializable {

    @FXML
    private TextField txtadresse;
    @FXML
    private AnchorPane root;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws AWTException, MalformedURLException, IOException {
        
        String adresse = txtadresse.getText();
   ;
    
       // String typee = type.getSelectionModel().getSelectedItem().toString();
        ServicesCommande srv  = new ServicesCommande();
        
       // Session session = new Session();
        Commande p = new Commande(70,300,adresse,"en cours");
        srv.ajouterCommande(p);
        
        Notification.sendNotification("Passer commande", "commande ",TrayIcon.MessageType.INFO);
        
          AnchorPane pane = FXMLLoader.load(getClass().getResource("AjoutCommande.fxml"));
         root.getChildren().setAll(pane);
        
        
    }
    
}
