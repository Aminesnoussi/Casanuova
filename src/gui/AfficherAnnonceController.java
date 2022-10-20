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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.AnnonceCRUD;

/**
 * FXML Controller class
 *
 * @author Mohamed Amine
 */
public class AfficherAnnonceController implements Initializable {

    private Stage stage;
    private Stage scene;
    private Stage root;

    @FXML
    private Button boutton_louer;
    @FXML
    private Button bouton_avendre;
    @FXML
    private TableView<Annonce> Tab;
    @FXML
    private TableColumn<Annonce, String> region_col;
    @FXML
    private TableColumn<Annonce, Float> prix_col;
    @FXML
    private TableColumn<Annonce, String> titre_col;
    @FXML
    private TableColumn<Annonce, String> duree_col;
    @FXML
    private TableColumn<Annonce, String> id_col;

    /**
     * Initializes the controller class.
     */
    ObservableList<Annonce> AnnList = FXCollections.observableArrayList();
    @FXML
    private Button butonajouter;
    @FXML
    private Button suppann;
    @FXML
    private TextField modtitre_input;
    @FXML
    private TextField modifprix_input;
    @FXML
    private TextField modifregion_input;
    @FXML
    private TextField modifdure_input;
    @FXML
    private Button button_modifAnoo;
    @FXML
    private Button pageprincipale;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        region_col.setCellValueFactory(new PropertyValueFactory<>("region"));
        prix_col.setCellValueFactory(new PropertyValueFactory<>("prix"));
        titre_col.setCellValueFactory(new PropertyValueFactory<>("titre"));
        duree_col.setCellValueFactory(new PropertyValueFactory<>("duree"));
        id_col.setCellValueFactory(new PropertyValueFactory<>("id_annonce"));
// TODO

        Tab.getSelectionModel().selectedItemProperty().addListener((value, oldValue, newValue) -> {
    if (newValue != null) {
        this.modtitre_input.setText(newValue.getTitre());
        this.modifprix_input.setText(Float.toString(newValue.getPrix()));
        this.modifregion_input.setText(newValue.getRegion());
        this.modifdure_input.setText(newValue.getDuree());
    }
});

    }

    @FXML
    private void affiche_alouer(ActionEvent event) {
        AnnList.clear();
        AnnonceCRUD cc = new AnnonceCRUD();
        List<Annonce> list = cc.afficher();
        AnnList.addAll(list.stream().filter(c -> c.getId_cat() == 1).collect(Collectors.toList()));
        Tab.setItems(AnnList);

    }

    @FXML
    private void affiche_avendre(ActionEvent event) {
        AnnList.clear();
        AnnonceCRUD cc = new AnnonceCRUD();
        List<Annonce> list = cc.afficher();
        AnnList.addAll(list.stream().filter(c -> c.getId_cat() == 2).collect(Collectors.toList()));
        Tab.setItems(AnnList);

    }

    @FXML
    private void ajouterbien(ActionEvent event) {

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("ajouter.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @FXML
    private void supprimerannonce(ActionEvent event) {

        Annonce pos = Tab.getSelectionModel().getSelectedItem();
        System.out.println(pos); 
        AnnonceCRUD cc = new AnnonceCRUD();
        cc.supprimerAnnonce(pos.getId_annonce());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Supprimer!");

                alert.show();

    }

    @FXML
    private void modiffAnnonce(ActionEvent event) {

        Annonce pos = Tab.getSelectionModel().getSelectedItem(); //getlobjet 
        pos.setTitre(this.modtitre_input.getText());
        pos.setPrix(Float.parseFloat(this.modifprix_input.getText())); // convert to float 
        pos.setRegion(this.modifregion_input.getText());
        pos.setDuree(this.modifdure_input.getText()!=null ? this.modifdure_input.getText() : ""); //if ? else :
        AnnonceCRUD cc = new AnnonceCRUD();
        cc.modifierAnnonce(pos);

    }

    @FXML
    private void agentpageprincipale(ActionEvent event) {
     try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }

}
