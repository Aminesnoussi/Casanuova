/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Annonce;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.AnnonceCRUD;

/**
 * FXML Controller class
 *
 * @author Mohamed Amine
 */
public class AjouterPourLeClientController implements Initializable {

    private Stage stage;
    private Stage scene;
    private Stage root;
    @FXML
    private TextField Typepclient;
    @FXML
    private TextField dureepourclient;
    @FXML
    private TextField regiondeclient;
    @FXML
    private TextField prixpourleclient;
    @FXML
    private Button button_confirmerclient;
    @FXML
    private MenuButton categoriinput;
    @FXML
    private Button accueilclient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        categoriinput.getItems().clear();
        MenuItem m1 = new MenuItem("A louer");
        MenuItem m2 = new MenuItem("A vendre");
        categoriinput.getItems().add(m1);
        categoriinput.getItems().add(m2);
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                categoriinput.setText(((MenuItem) e.getSource()).getText());
            }
        };

        // add action events to the menuitems 
        m1.setOnAction(event1);
        m2.setOnAction(event1);
    }

    @FXML
    private void confirmerpourclient(ActionEvent event) {

        String titre, duree, region, prix, cat;
        titre = "S+" + Typepclient.getText();
        duree = dureepourclient.getText();
        region = regiondeclient.getText();
        prix = prixpourleclient.getText();
        cat = categoriinput.getText();

        if (cat.equals("A vendre")) {
//            Annonce A1 = new Annonce(titre, duree, region, Float.parseFloat(prix), 1);
            AnnonceCRUD cc = new AnnonceCRUD();
            //convert titre_input to integer
            int val = Integer.parseInt(Typepclient.getText());
            if (val < 1 || val > 10) {
                //titre.equals("")
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("titre vide!");

                alert.show();
            } else {
                Annonce A1 = new Annonce(titre, duree, region, Float.parseFloat(prix), 1);

                cc.ajouterAnnonce(A1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Annonce insérée avec succés!");

                alert.show();

            }
        } else {

            Annonce A1 = new Annonce(titre, duree, region, Float.parseFloat(prix), 2);
            AnnonceCRUD cc = new AnnonceCRUD();
            cc.ajouterAnnonce(A1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information Dialog");

            alert.setHeaderText(null);

            alert.setContentText("Annonce insérée avec succés!");

            alert.show();

        }
    }

    @FXML
    private void accueilpourclient(ActionEvent event) {

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("EspaceClient.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
