/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.module;

import debo.Authentication;
import debo.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private Text username;
    @FXML
    private PasswordField pwd;
    @FXML
    private PasswordField nbPwd;
    
    
    public void redirectLivraison(MouseEvent event) throws IOException{
        BorderPane root = FXMLLoader.load(getClass().getResource("add_user.fxml"));   
        root.getChildren().setAll(root);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText(Authentication.authenticatedUser.getUsername());
    }    

    @FXML
    private void redirectDashboard(MouseEvent event) {
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
    
    }

    @FXML
    private void hover(MouseEvent event) {
    }

    @FXML
    private void redirectUser(MouseEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("/user/module/users_list.fxml"));
            Scene hoomescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(hoomescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void modifierProfileRedirect(MouseEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("/user/module/edit_profile.fxml"));
            Scene hoomescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(hoomescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void logout(ActionEvent event) {
        Authentication.logout();
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("/user/module/login.fxml"));
            Scene hoomescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(hoomescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void changer(ActionEvent event) {
        Connection connection = DBConnection.getInstance().getConnexion();
        User user = Authentication.authenticatedUser;
        if(user.getPassword().equals(pwd.getText())){
            String  query  = "UPDATE fos_user SET password = ? WHERE username = ?";
            PreparedStatement preparedStmt;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, nbPwd.getText());
                preparedStmt.setString (2, user.getUsername());
                preparedStmt.execute();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erreur");
            alert.setContentText("Mot de passe incorrect");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void retourner(MouseEvent event) {
        Stage stage = new Stage();
        Parent home;
        try {
            home = FXMLLoader.load(getClass().getResource("/user/module/edit_profile.fxml"));
            Scene hoomescene = new Scene(home);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(hoomescene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
