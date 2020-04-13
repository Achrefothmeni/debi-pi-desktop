/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderCollapsePropertyValue;
import com.itextpdf.layout.property.TextAlignment;
import debo.Authentication;
import debo.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.knowm.xchart.BitmapEncoder;
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
    
    ArrayList<String> names2 = new ArrayList();
    ArrayList<Integer> occ2 = new ArrayList();
    ArrayList<String> names = new ArrayList();
    ArrayList<Integer> occ = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        names = new ArrayList();
        occ = new ArrayList();
        names2 = new ArrayList();
        occ2 = new ArrayList();
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

    @FXML
    private void exporter(ActionEvent event) throws IOException {
        DonutChart DonutChart = new DonutChart();
        org.knowm.xchart.PieChart chart3 = DonutChart.getChart(names2, occ2,"Pourcentage par categorie");
        try {
            BitmapEncoder.saveBitmap(chart3, "./piechart", BitmapEncoder.BitmapFormat.PNG);
        
        
        //PdfFont courier = PdfFontFactory.createFont(FontConstants.COURIER);
        String louisFontPath = "./Louis George Cafe.ttf";
        FontProgram fontProgram = FontProgramFactory.createFont(louisFontPath);
        PdfFont louisFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, true);
        String dest = "./dashboard.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        Paragraph reportTitle = new Paragraph("Dashboard Debo").setFont(louisFont).setFontSize(16).setTextAlignment(TextAlignment.CENTER);
        Paragraph date = new Paragraph(new Date().toString()).setFont(louisFont).setFontSize(8).setTextAlignment(TextAlignment.CENTER);
        document.add(reportTitle);
        document.add(date);
        document.add(new Paragraph("\n"));
        
        Table table3Chart = new Table(3);
        table3Chart.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
        table3Chart.setHorizontalBorderSpacing(50);        
        table3Chart.addCell(new Cell().add(new Paragraph(nbLivText.getText()).setFontSize(16).setFontColor(DeviceGray.BLACK).setFont(louisFont)).setBorder(Border.NO_BORDER).setBackgroundColor(new DeviceRgb(176, 190,197)));
        table3Chart.addCell(new Cell().add(new Paragraph(nbCmdText.getText()).setFontSize(16).setFontColor(DeviceGray.BLACK).setFont(louisFont)).setBorder(Border.NO_BORDER).setBackgroundColor(new DeviceRgb(176, 190,197)));
        table3Chart.addCell(new Cell().add(new Paragraph(nbUsersText.getText()).setFontSize(16).setFontColor(DeviceGray.BLACK).setFont(louisFont)).setBorder(Border.NO_BORDER).setBackgroundColor(new DeviceRgb(176, 190,197)));
        
        document.add(table3Chart);
        document.add(new Paragraph("\n"));
        
        ImageData data = ImageDataFactory.create("./piechart.png");
        Image datachart = new Image(data);
        datachart.scale(0.5f,0.5f);
        //document.add(datachart);
        
        Table top3 = new Table(2);
        top3.setMarginRight(0);
        top3.setFontSize(10);
        Cell title3 = new Cell(1,2).setBorder(Border.NO_BORDER);
        title3.setBackgroundColor( new DeviceRgb(51, 52, 64));
        title3.add(new Paragraph("Top 3 article").setFont(louisFont).setFontColor(DeviceGray.WHITE));
        top3.addCell(title3);
        top3.addCell(new Cell().setWidth(33).add(new Paragraph("Label").setFontColor(DeviceGray.BLACK).setFont(louisFont)).setBorder(Border.NO_BORDER).setBackgroundColor( new DeviceRgb(207,216,220)));
        top3.addCell(new Cell().add(new Paragraph("Qte commandé").setFontColor(DeviceGray.BLACK).setFont(louisFont)).setBorder(Border.NO_BORDER).setBackgroundColor( new DeviceRgb(207,216,220)));

        for(int i = 0; i < names.size(); i++){
            if(i%2==0){
            top3.addCell( new Cell().add(new Paragraph(names.get(i))).setBorder(Border.NO_BORDER).setBackgroundColor( new DeviceRgb(249, 255, 253)).setFont(louisFont).setFontColor(new DeviceRgb(62,64,63)));
            top3.addCell( new Cell().add(new Paragraph( String.valueOf(occ.get(i)))).setBorder(Border.NO_BORDER).setBackgroundColor( new DeviceRgb(249, 255, 253)).setFont(louisFont).setFontColor(new DeviceRgb(62,64,63)));

        }
        else{
            top3.addCell( new Cell().add(new Paragraph(names.get(i))).setBorder(Border.NO_BORDER).setBackgroundColor( new DeviceRgb(249, 255, 253)).setFont(louisFont).setFontColor(new DeviceRgb(62,64,63)));
            top3.addCell( new Cell().add(new Paragraph( String.valueOf(occ.get(i)))).setBorder(Border.NO_BORDER).setBackgroundColor( new DeviceRgb(249, 255, 253)).setFont(louisFont).setFontColor(new DeviceRgb(62,64,63)));
            }
        }
        
        Table container = new Table(2);
        container.addCell(new Cell().add(datachart).setBorder(Border.NO_BORDER).setPaddingRight(51f).setPaddingBottom(15f));
        container.addCell(new Cell().add(top3 ).setBorder(Border.NO_BORDER).setPaddingBottom(15f));
        document.add(container);
        document.close();
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirmation");
        alert.setContentText("Votre rapport a été exporter avec succée dans C:user/dell/document/netbeansproject/debo/dashboard.pdf");
        alert.showAndWait();
        } 
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erreur");
            alert.setContentText("Erreur lorsl'exportation du rapport");
            alert.showAndWait();
            Logger.getLogger(DashboardHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
