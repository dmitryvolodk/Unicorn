import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoverViewerCustomListView extends Application {   
    
   @Override // Override the start method in the Application class
   public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("CoverViewerCustomListView.fxml"));
      Scene scene = new Scene(root);   // Create a scene
      stage.setTitle("Cover Viewer");  // Set the stage title
      stage.setScene(scene);           // Place the scene in the stage
      stage.show();                    // Display the stage
   }

   /**
    * The main method is needed for the IDE with limited JavaFX support only.
    */
   public static void main(String[] args) {
      launch(args);
   }
}