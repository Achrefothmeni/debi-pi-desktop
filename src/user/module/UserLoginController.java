/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.module;

import debo.Authentication;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class UserLoginController implements Initializable {
    
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    
    @FXML
    public void login(ActionEvent event) throws NoSuchAlgorithmException{
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findOne(username.getText());
        if(user.getUsername() == null){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Attention !");
            alert.setContentText("Utilisiteur introuvable");
            alert.showAndWait();
        }
        else{
            if(Authentication.checkPass(password.getText(), user.getPassword())){
                Authentication.isAuthenticated = true;
                Authentication.authenticatedUser = user;
                Stage stage = new Stage();
                Parent home;
                try {
                    home = FXMLLoader.load(getClass().getResource("/dashboard/dashboard_home.fxml"));
                    Scene hoomescene = new Scene(home);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(hoomescene);
                    app_stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Authentication successfull");
            }
            else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Attention !");
                alert.setContentText("Veuillez vérifier votre informations de connexion");
                alert.showAndWait();
            }
        }
    }
            
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
