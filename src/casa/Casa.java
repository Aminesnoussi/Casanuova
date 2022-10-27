package casa;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Casa extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
      try{ 
            Parent root= FXMLLoader.load(getClass().getResource("FXMLogin.fxml")) ;
            Scene scene = new Scene(root) ;
            stage.initStyle(StageStyle.UNDECORATED); 
            stage.setScene(scene);
            stage.show();
      } catch (IOException ex) {
            System.out.println(ex.getMessage());}
    } 
  
    public static void main(String[] args) {
                launch(args);

    }
    
    
}
