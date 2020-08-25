import javafx.application.Application;  // class defines essential framework for writing JavaFX program
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {
    
   @Override // Override the start method in the Application class
   public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
      Scene scene = new Scene(root);     // Create a scene, and attach scene graph to scene
      stage.setTitle("Tip Calculator");  // Set the stage title
      stage.setScene(scene);             // Place the scene in the stage
      stage.show();                      // Display the stage
   }

    /**
     * The main method is needed for the IDE with limited JavaFX support only.
     */
   public static void main(String[] args) {
      launch(args); 
   }
}