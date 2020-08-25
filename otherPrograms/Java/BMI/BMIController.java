import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BMIController implements Initializable {

    @FXML
    private Label label; // creat a label to display BMI number result
    @FXML
    private Label label1;  // creat a label to display BMI word result, e.g. "Underweight"
    @FXML
    private RadioButton pi; // creat a radiobutton to choose the U.S. units of mesurement
    @FXML
    private RadioButton km; // creat a radiobutton to choose the Metric units of mesurement
    @FXML
    private TextField weight; // creat a textfield to allow the user to enter the weight
    @FXML
    private TextField height; // creat a textfield to allow the user to enter the height
    @FXML
    private Button button;  // creat a button for the user to instantiate the calculation
    @FXML
    private ToggleGroup ip; // creat a toggle group for the radio buttons

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Double w = new Double(weight.getText()); // initialize the variable to save the read weight value
            Double h = new Double(height.getText()); // initialize the variable to save the read height value
            Double bmi; // define the BMI variable to store the number value of BMI
            String bmi1 = ""; // define the BMI variable to store the word value of BMI

            // if the user selected U.S. units of megurement
            if (pi.isSelected()) {
                bmi = (w * 703.0) / (h * h);  // Calculate the BMI
                label.setText(String.format("%.2f", bmi));  // Display the BMI number value to the user
                // identify the word value of BMI
                if(bmi < 18.5)
                    bmi1 = "-Underweight";
                else if(bmi < 25)
                    bmi1 = "-Normal";
                else if(bmi < 30)
                    bmi1 = "-Overweight";
                else
                    bmi1 = "-Obese";
                label1.setText(bmi1);  // Display the BMI word value to the user
            // if the user selected Metric units of megurement
            } else if (km.isSelected()) {
                bmi = w / (h * h);  // Calculate the BMI
                label.setText(String.format("%.2f", bmi));  // Display the BMI number value to the user
                // identify the word value of BMI
                if(bmi < 18.5)
                    bmi1 = "-Underweight";
                else if(bmi < 25)
                    bmi1 = "-Normal";
                else if(bmi < 30)
                    bmi1 = "-Overweight";
                else
                    bmi1 = "-Obese";
                label1.setText(bmi1);  // Display the BMI word value to the user
            }
        // Check for the excetion of the correct value entered by a user    
        } catch (NumberFormatException nf) {
            weight.setText("Please enter valid value");
            weight.selectAll();
            weight.requestFocus();
            height.setText("Pleaes enter valid value");
            height.selectAll();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
// TODO
    }

}
