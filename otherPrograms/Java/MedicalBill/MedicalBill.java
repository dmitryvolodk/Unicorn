import javafx.application.Application;  // class defines essential framework for writing JavaFX program
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MedicalBill extends Application {
     
    @Override // Override the start method in the Application class
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);                // Create a scene
        stage.setTitle("ViVo Healthcare");            // Set the stage title
        stage.getIcons().add(new Image("logo.jpg"));  // Place a logo in the stage
        stage.setScene(scene);                        // Place the scene in the stage
        stage.show();                                 // Display the stage
    }
   
    /**
     * The main method is needed for the IDE with limited JavaFX support only.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
