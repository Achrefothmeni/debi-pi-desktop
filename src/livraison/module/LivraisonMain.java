/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.module;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author syrina
 */
public class LivraisonMain extends Application {

    //private FileChooser fc = new FileChooser();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
   
       /* Button btn_voir = new Button();
        btn_voir.setText("Save to PDF");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*.pdf"));
        fc.setTitle(("Save to PDF"));
        fc.setInitialFileName("untitled.pdf");
        btn_voir.setOnAction((ActionEvent event) ->{
            File file = fc.showSaveDialog(primaryStage);
            if (file!=null){
                String str = file.getAbsolutePath();
                try {
                    FileOutputStream fos = new FileOutputStream(str);
                    PDF pdf = new PDF(fos);
                    Page page = new Page(pdf, Letter.LANDSCAPE);
                    pdf.close();
                    fos.flush();
               
            }   catch (IOException ex) {
                    Logger.getLogger(LivraisonMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(LivraisonMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    });*/
        
        Parent root = FXMLLoader.load(getClass().getResource("affichage_livraison.fxml"));     
        Scene scene = new Scene(root);
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


   
