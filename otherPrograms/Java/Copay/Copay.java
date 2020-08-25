import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Copay extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Copay.fxml"));
        // to place the BMI calculator on the scene, and scene on the stage to display the calculator
        Scene scene = new Scene(root);
        stage.setTitle("Copay CALCULATOR");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}