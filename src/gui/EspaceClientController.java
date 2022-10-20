/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Annonce;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.AnnonceCRUD;

/**
 * FXML Controller class
 *
 * @author Mohamed Amine
 */
public class EspaceClientController implements Initializable {

    private Stage stage;
    private Stage scene;
    private Stage root;
    @FXML
    private Button button_Avendreclient;
    @FXML
    private Button button_Alouerclient;
    @FXML
    private Button ajoudebienClient;

    @FXML
    private TableView<Annonce> Tab;
    @FXML
    private TableColumn<Annonce, String> region_col1;
    @FXML
    private TableColumn<Annonce, Float> prix_col1;
    @FXML
    private TableColumn<Annonce, String> titre_col1;
    @FXML
    private TableColumn<Annonce, String> duree_col1;

    /**
     * Initializes the controller class.
     */
    ObservableList<Annonce> AnnList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        region_col1.setCellValueFactory(new PropertyValueFactory<>("region"));
        prix_col1.setCellValueFactory(new PropertyValueFactory<>("prix"));
        titre_col1.setCellValueFactory(new PropertyValueFactory<>("titre"));
        duree_col1.setCellValueFactory(new PropertyValueFactory<>("duree"));
        //Tab.getColumns().addAll(region_col1,prix_col1,titre_col1,duree_col1);

    }

    @FXML
    private void Avendrepourclient(ActionEvent event) {
        AnnList.clear();
        AnnonceCRUD cc = new AnnonceCRUD();
        List<Annonce> list = cc.afficher();
        AnnList.addAll(list.stream().filter(c -> c.getId_cat() == 1).collect(Collectors.toList()));
        Tab.setItems(AnnList);

    }

    @FXML
    private void AlouerPourclient(ActionEvent event) {
        AnnList.clear();
        AnnonceCRUD cc = new AnnonceCRUD();
        List<Annonce> list = cc.afficher();
        AnnList.addAll(list.stream().filter(c -> c.getId_cat() == 2).collect(Collectors.toList()));

        Tab.setItems(AnnList);

    }

    @FXML
    private void ajoudeblientPourclient(ActionEvent event) {

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("AjouterPourLeClient.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }
}
