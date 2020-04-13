/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.module;

import debo.Authentication;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AddUserController implements Initializable {
    
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private PasswordField password;
    @FXML
    private TextField matFiscal;
    @FXML
    private TextField numTel;
    @FXML
    private ComboBox role;
    @FXML
    private Button addUserBtn;
    @FXML
    private Text usernameText;
    @FXML
    private Button generatePwd;
    
    User user = new User();
    
    @FXML
    private void checkUserRole(){
        String selectedRole = role.getSelectionModel().getSelectedItem().toString();
        if(selectedRole.equals("Magasinier")){
            user.setRoles("a:1:{i:0;s:22:"+'"'+"ROLE_WAREHOUSE_MANAGER"+'"'+";}");
            matFiscal.clear();
            matFiscal.setDisable(true);
        }
        else if(selectedRole.equals("Livreur")){
            user.setRoles("a:1:{i:0;s:21:"+'"'+"ROLE_DELIVERY_MANAGER"+'"'+";}");
            System.out.println(user.getRoles());
            matFiscal.clear();
            matFiscal.setDisable(true);

        }
        else if(selectedRole.equals("Client")){
            user.setRoles("a:1:{i:0;s:11:"+'"'+"ROLE_CLIENT"+'"'+";}");
            matFiscal.setDisable(false);
        }
        else{
            user.setRoles("a:1:{i:0;s:16:"+'"'+"ROLE_FOURNISSEUR"+'"'+";}");
            matFiscal.setDisable(false);
        }
    }
    
    @FXML
    private void addUser(){
        user.setUsername(username.getText());
        user.setEmail(email.getText());
        user.setMatFiscal(matFiscal.getText());
        user.setPassword(password.getText());
        user.setNom(nom.getText());
        user.setPrenom(prenom.getText());
        user.setNumTel(Integer.parseInt(numTel.getText()));
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        User savedUser = userDAO.findOne(user.getUsername());
        if(savedUser.getUsername()!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Confirmation");
            alert.setContentText("Utilisateur ajouté avec succés");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erreur");
            alert.setContentText("Ajout de l'utilisateur est echoué");
            alert.showAndWait();
        }
        
    }    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        role.getItems().clear();
        role.getItems().addAll("Magasinier", "Livreur", "Client", "Fournisseur");
        usernameText.setText(Authentication.authenticatedUser.getUsername());
        //role.getItems().add("Magasinier");
       // comboBox.getSelectionModel().select("Option B");
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
    private void validateNumTel(KeyEvent event) {
        if(!numTel.getText().matches("[0-9]+")){
            numTel.clear();
        }
    }

    @FXML
    private void modiferProfileRedirect(MouseEvent event) {
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
    private void retourner(MouseEvent event) {
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
    
}
