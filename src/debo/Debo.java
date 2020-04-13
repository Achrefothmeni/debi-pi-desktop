/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debo;

import com.pdfjet.A4;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.stream.FileCacheImageOutputStream;

/**
 *
 * @author dell
 */
public class Debo extends Application {   
   
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
     
        
      /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Connection connection = DBConnection.getInstance().getConnexion();
                System.out.println("Hello World!");
                User user = new User("testjava", "testjava", "tt@e.e", "tt@e.e", "azaz", "a:1:{i:0;s:16:"+'"'+"ROLE_SUPER_ADMIN"+'"'+";}", "az", "az", "Disponible", "sdsd", 123323);
                UserDAO userDAO = new UserDAO();
                userDAO.save(user);
                
                
                java.util.Date today = new java.util.Date();
                java.sql.Date sqlToday = new java.sql.Date(today.getTime());
                Livraison livraison = new Livraison(sqlToday, 60, "123TUN4344");
                //Livraison livraison2 = new Livraison("En attente", sqlToday, 66, "123TUN4359");
                LivraisonDAO livraisonDAO = new LivraisonDAO();
                livraisonDAO.save(livraison);
                //livraisonDAO.save(livraison2);
                livraison.setId(78);
                livraison.setFlotte("123TUN4352");
                livraisonDAO.update(livraison);
                
                ArrayList<Livraison> livraisons = livraisonDAO.findAll();
                System.out.println(livraisons);
                
                Livraison L2 = livraisonDAO.findOne(40);
                System.out.println(L2);
                
            }
            });
               */ }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*throws FileNotFoundException, Exception {
        // create a file output stream to save the pdf
        FileOutputStream fos = new FileOutputStream("livraisonfile.pdf");
        // create the pdf 
        PDF pdf = new PDF(fos);
        // create a page in the pdf
        Page page = new Page(pdf, A4.PORTRAIT);
        //close the pdf and output stream
        pdf.close();
        fos.close();
        //let's get the location of the file
        Path file = Paths.get("livraisonfile.pdf");        
        System.out.println("PDF file was saved to: " + file.toAbsolutePath().toString());
    }*/
    }
}
       