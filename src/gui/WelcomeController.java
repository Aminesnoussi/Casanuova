/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed Amine
 */
public class WelcomeController implements Initializable {
 private Stage stage ; 
 private Stage scene ; 
 private Stage root ;
    @FXML
    private Button button_clientanno;
    @FXML
    private Button button_agentann;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clientannonce(ActionEvent event) {
     try{
                 Parent root ;
            root=FXMLLoader.load(getClass().getResource("espaceClient.fxml"));
           stage=(Stage)((Node)event.getSource()).getScene().getWindow() ; 
            Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.show();
              
            }
          catch (IOException ex) {

      System.out.println(ex.getMessage()) ;   }
        }
    
    
    

    @FXML
    private void agentannonce(ActionEvent event) {
    
       try{
                 Parent root ;
            root=FXMLLoader.load(getClass().getResource("afficherAnnonce.fxml"));
           stage=(Stage)((Node)event.getSource()).getScene().getWindow() ; 
            Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.show();
              
            }
          catch (IOException ex) {

      System.out.println(ex.getMessage()) ;   }
        }
    
    }
    
