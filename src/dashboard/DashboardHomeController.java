/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import debo.Authentication;
import debo.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import user.module.User;
import user.module.UserLoginController;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class DashboardHomeController implements Initializable {

    @FXML
    private Text username;
    @FXML
    private Text nbCmdText;
    @FXML
    private Text nbUsersText;
    @FXML
    private Text nbLivText;
    @FXML
    private BarChart<?, ?> barChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection connection = DBConnection.getInstance().getConnexion();
        username.setText(Authentication.authenticatedUser.getUsername());
        String query = "SELECT COUNT(*) FROM fos_user";
        PreparedStatement preparedStmt;
        User user = new User();
        try{
            preparedStmt = connection.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                nbUsersText.setText(String.valueOf(rs.getInt(1))+" utilisateurs");
            }
            query = "SELECT COUNT(*) FROM commande";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeQuery();
            rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                nbCmdText.setText(String.valueOf(rs.getInt(1))+" commandes");
            }
            query = "SELECT COUNT(*) FROM livraison";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeQuery();
            rs = preparedStmt.executeQuery();
            while ( rs.next() ){
                nbLivText.setText(String.valueOf(rs.getInt(1))+" livraisons");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Article");
        
        dataSeries1.getData().add(new XYChart.Data("Desktop", 567));
        dataSeries1.getData().add(new XYChart.Data("Phone"  , 65));
        dataSeries1.getData().add(new XYChart.Data("Tablet"  , 23));
        
         barChart.getData().add(dataSeries1);
         
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
    private void hover(MouseEvent event) {
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
    
}
