
package casa;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Utility {
    
    
    public static void changeToScene (Class aClass, Event aEvent ,String sceneFileStr) throws Exception
    {
    Parent root= FXMLLoader.load(aClass.getResource(sceneFileStr)) ;
    Scene scene = new Scene(root) ;
    Stage stage = (Stage) ((Node) aEvent.getSource()).getScene().getWindow() ;
    stage.setScene(scene);
    stage.show();
    }
}
