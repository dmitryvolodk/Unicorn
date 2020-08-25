/**
 * The name of the program: "Medical billing"
 * 
 * Author: Violette Volodkevich
 * 
 * Description of the program:
 * 
 * The goal of the Medical Billing program is to increase billing transparency and understanding
 * for patients  about copays for various insurance providers and medical services. 
 * 
 * Autobilling process of the applications starts with selecting a radio button with an
 * insurance name. It triggers the display of the copay rates for that insurance and all services.
 * The displayed copays give the patient an opportunity to plan for future medical expences and choose
 * at lease one of the medical services for calculation. Now, the user chooses at lease one 
 * check box with medical services that were attended. Then, "Calculate" button is clicked.
 * It initiates addition of all copays and identification of the discount with
 * the final amount due for the patient. In a case, if the user makes a mistake in the
 * selection or changes the mind about what insurance and medical services to choose,
 * the button "Reset" comes in place. First, the user unselects the selected check boxes,
 * and then click on "Reset" button, what give the patient an opportunity
 * to start over the calculation process. The patient exits the program by clicking on "X"
 * button at the top right conner of the Medical billing window.
 * 
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;

public class FXMLDocumentController {

    int copay$ = 0;               // Declare and initialize the sum of all copays for services attended
    String medicalServices = "",  // Declare and initialize a combination of medical services names 
            insurance = "";       // Declare and initialize an insurance name
    Statement statement;          // Declare the reference variable for the interface object "Statement" for executing queries
    Connection connection;        // Declare the reference variable for the interface object "Connection"  
    ResultSet resultSet;          // Declare the reference variable for the interface object "ResultSet"

    @FXML
    private Label lbDiscountAmt, lbSubtotalAmt, lbResult, // Labels to display the discount and sum of copays
            lbPrimaryCare, lbSpecialist, lbImaging, lbGenericDrugs,                       // Labels to preview copays
            lbPreferredDrugs, lbNonPreferredDrugs, lbOutpatientSurgery, lbEmergency,      // Labels to preview copays
            lbUrgent, lbHospitalFacility, lbBehavioralOutpatient, lbBehavioralInpatient,  // Labels to preview copays
            lbChildbirth, lbRehabilitation, lbHabilitation;                               // Labels to preview copays

    // Request copay data from the database to calculate the copay sum for the attended services
    @FXML
    private void calculateBillButtonAction(ActionEvent event) {
        try {
            // Execute an SQL statement and return a ResultSet object
            ResultSet resultSet = statement.executeQuery("select medicalService, copay$ "
                    + "from " + insurance + " "
                    + "where medicalService in (" + medicalServices.substring(0, medicalServices.length() - 1) + ")");

            // Retrieve the query result (medical service name(s) & copay amount(s)) from the ResultSet object
            // Sum all copays for services that were attended
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
                copay$ = copay$ + Integer.parseInt(resultSet.getString(2));
            }

            // Close the connection and release resources related to the connection
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Display the subtotal for the patient's copays
        lbSubtotalAmt.setText(copay$ * 1.0 + "");

        // Identify and dsplay the discount and the total due for the patient
        if (copay$ >= 150) {
            lbDiscountAmt.setText((copay$ * 0.10) + "");
            lbResult.setText((copay$ - copay$ * 0.10) + "");
        } else {
            lbDiscountAmt.setText("0.00");
            lbResult.setText(copay$ + "");
        }
        copay$ = 0;
        medicalServices = "";
    }

    // Reset the values of the patient's selection to be able to choose other options and recalculate the copay(s)
    @FXML
    private void resetButtonAction(ActionEvent event) {
        initializeDB();  // Reinitialize database connection and create a Statement object          
        medicalServices = "";
        copay$ = 0;
        lbSubtotalAmt.setText("0");
        lbDiscountAmt.setText("0");
        lbResult.setText("0");
    }

    /**
     * Check boxes to choose the medical service(s) and a combine service names
     */
    @FXML
    private void primaryCareCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Primary care visit for illness',";
    }

    @FXML
    private void SpecialistCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Specialist visit',";
    }

    @FXML
    private void ImagingCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Imaging - CT/PET scans, MRIs',";
    }

    @FXML
    private void GenericDrugsCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Generic drugs',";
    }

    @FXML
    private void PreferredDrugsCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Preferred brand drugs',";
    }

    @FXML
    private void NonPreferredDrugsCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Non-preferred brand drugs',";
    }

    @FXML
    private void OutpatientSurgeryCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Outpatient surgery facility fee',";
    }

    @FXML
    private void EmergencyCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Emergency room care',";
    }

    @FXML
    private void UrgentCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Urgent care',";
    }

    @FXML
    private void HospitalFacilityCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Hospital stay facility fee',";
    }

    @FXML
    private void BehavioralOutpatientCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Behavioral health outpatient services',";
    }

    @FXML
    private void BehavioralInpatientCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Behavioral health inpatient services',";
    }

    @FXML
    private void ChildbirthCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Childbirth/delivery facility services',";
    }

    @FXML
    private void RehabilitationCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Rehabilitation services',";
    }

    @FXML
    private void HabilitationCheckBoxAction(ActionEvent event) {
        medicalServices = medicalServices + "'Habilitation services',";
    }

    /**
     * Radio buttons to choose an insurance provider
     */
    @FXML
    private void BCBSRadioButtonAction(ActionEvent event) {
        insurance = "BCBS";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request BCBS copay amounts from the database for patient's priview
    }

    @FXML
    private void BMCRadioButtonAction(ActionEvent event) {
        insurance = "BMC";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request BMC copay amounts from the database for patient's priview
    }

    @FXML
    private void ConnecticareRadioButtonAction(ActionEvent event) {
        insurance = "Connecticare";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request Connecticare copay amounts from the database for patient's priview
    }

    @FXML
    private void FallonRadioButtonAction(ActionEvent event) {
        insurance = "Fallon";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request Fallon copay amounts from the database for patient's priview
    }

    @FXML
    private void HarvardPilgrimRadioButtonAction(ActionEvent event) {
        insurance = "HarvardPilgrim";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request HarvardPilgrim copay amounts from the database for patient's priview
    }

    @FXML
    private void HealthNewEnglandRadioButtonAction(ActionEvent event) {
        insurance = "HealthNewEngland";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request HealthNewEngland copay amounts from the database for patient's priview
    }

    @FXML
    private void MedicareRadioButtonAction(ActionEvent event) {
        insurance = "Medicare";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request Medicare copay amounts from the database for patient's priview
    }

    @FXML
    private void NeighborhoodHealthPlanRadioButtonAction(ActionEvent event) {
        insurance = "NeighborhoodHealthPlan";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request NeighborhoodHealthPlan copay amounts from the database for patient's priview
    }

    @FXML
    private void TuftsRadioButtonAction(ActionEvent event) {
        insurance = "Tufts";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request Tufts copay amounts from the database for patient's priview
    }

    @FXML
    private void UnitedHealthCareRadioButtonAction(ActionEvent event) {
        insurance = "UnitedHealthCare";
        initializeDB();    // Initialize database connection and create a Statement object
        requestDBtable();  // Request UnitedHealthCare copay amounts from the database for patient's priview
    }

    // Method to initialize database connection and create a Statement object
    public void initializeDB() {
        try {
            // Load the JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // Connect to a database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/insurances", "scott", "tiger");
            System.out.println("Database connected");

            // Create a statement object
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    // Method to request copay amounts from the database to show to the patient before selection of the medical services
    public void requestDBtable() {
        try {
            // Execute an SQL statement and return a ResultSet object
            resultSet = statement.executeQuery("select medicalService, copay$ "
                    + "from " + insurance + " ");

            // Retrieve the query result (medical service names & copay amounts) from the ResultSet object to show to the patient
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
                switch (resultSet.getString(1)) {
                    case "Primary care visit for illness":
                        lbPrimaryCare.setText(resultSet.getString(2) + "");
                        break;
                    case "Specialist visit":
                        lbSpecialist.setText(resultSet.getString(2) + "");
                        break;
                    case "Imaging - CT/PET scans, MRIs":
                        lbImaging.setText(resultSet.getString(2) + "");
                        break;
                    case "Generic drugs":
                        lbGenericDrugs.setText(resultSet.getString(2) + "");
                        break;
                    case "Preferred brand drugs":
                        lbPreferredDrugs.setText(resultSet.getString(2) + "");
                        break;
                    case "Non-preferred brand drugs":
                        lbNonPreferredDrugs.setText(resultSet.getString(2) + "");
                        break;
                    case "Outpatient surgery facility fee":
                        lbOutpatientSurgery.setText(resultSet.getString(2) + "");
                        break;
                    case "Emergency room care":
                        lbEmergency.setText(resultSet.getString(2) + "");
                        break;
                    case "Urgent care":
                        lbUrgent.setText(resultSet.getString(2) + "");
                        break;
                    case "Hospital stay facility fee":
                        lbHospitalFacility.setText(resultSet.getString(2) + "");
                        break;
                    case "Behavioral health outpatient services":
                        lbBehavioralOutpatient.setText(resultSet.getString(2) + "");
                        break;
                    case "Behavioral health inpatient services":
                        lbBehavioralInpatient.setText(resultSet.getString(2) + "");
                        break;
                    case "Childbirth/delivery facility services":
                        lbChildbirth.setText(resultSet.getString(2) + "");
                        break;
                    case "Rehabilitation services":
                        lbRehabilitation.setText(resultSet.getString(2) + "");
                        break;
                    case "Habilitation services":
                        lbHabilitation.setText(resultSet.getString(2) + "");
                        break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
