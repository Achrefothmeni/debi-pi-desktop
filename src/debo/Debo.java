/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debo;

import java.sql.Connection;
import java.sql.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import user.module.dao.UserDAO;
import user.module.model.User;

/**
 *
 * @author dell
 */
public class Debo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Connection connection = DBConnection.getInstance().getConnexion();
                System.out.println("Hello World!");
                User user = new User("testjava", "testjava", "tt@e.e", "tt@e.e", "azaz", "a:1:{i:0;s:16:"+'"'+"ROLE_SUPER_ADMIN"+'"'+";}", "az", "az", "Disponible", "sdsd", 123323);
                UserDAO userDAO = new UserDAO();
                userDAO.save(user);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
