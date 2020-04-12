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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
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
    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> names = new ArrayList();
        ArrayList<Integer> occ = new ArrayList();
        ArrayList<String> names2 = new ArrayList();
        ArrayList<Integer> occ2 = new ArrayList();
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
            query = "SELECT COUNT(*) AS `occ`, `article`.`name` FROM `lignecommande`, `article` WHERE `lignecommande`.`id_produit`=`article`.`id_article`  GROUP BY id_produit order by `occ` desc limit 3";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeQuery();
            rs = preparedStmt.executeQuery();
            
            while ( rs.next() ){
                names.add(rs.getString("name"));
                occ.add(rs.getInt("occ"));
            }
            query = "SELECT COUNT(*) AS `occ`, `category`.`label` FROM `article`, `category` WHERE `article`.`id_category` = `category`.`id_category` GROUP BY `article`.`id_category`";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.executeQuery();
            rs = preparedStmt.executeQuery();
            
            while ( rs.next() ){
                names2.add(rs.getString("label"));
                occ2.add(rs.getInt("occ"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Article");
        
        dataSeries1.getData().add(new XYChart.Data(names.get(0), occ.get(0)));
        dataSeries1.getData().add(new XYChart.Data(names.get(1), occ.get(1)));
        dataSeries1.getData().add(new XYChart.Data(names.get(2), occ.get(2)));
        
         barChart.getData().add(dataSeries1);
         
         for (int i=0 ;i<names2.size();i++){
             pieChart.getData().add(new PieChart.Data(names2.get(i), occ2.get(i)));
         }
         
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
