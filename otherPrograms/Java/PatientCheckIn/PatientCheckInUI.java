import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientCheckInUI extends Application{
    private TextField tfMedicalRecordNumber = new TextField();
    private TextField tfPatientsFirstName = new TextField();
    private TextField tfPatientsLastName = new TextField();
    private TextField tfPatientsDateOfBirth = new TextField();
    private TextField tfVisitCoverage = new TextField();
    private TextField tfMemberIdNumber = new TextField();
    private TextField tfGroupNumber = new TextField();
    private TextField tfClaimAddress = new TextField();
    private TextField tfStartDate = new TextField();
    private TextField tfPatientSubscriberRelationship  = new TextField();
    private TextField tfSubscribersFirstName  = new TextField();
    private TextField tfSubscribersLastName  = new TextField();
    private TextField tfSubscribersDateOfBirth = new TextField();
    private TextField tfIsRoutineVisit = new TextField();
    private TextField tfPhysicalExaminationDescription = new TextField();
    private TextField tfNotRoutineVisitReason = new TextField();
    private TextField tfRegularActivities = new TextField();
    private TextField tfInstrumentalActivities = new TextField();
    private TextField tfYangAlcoholUse = new TextField();
    private TextField tfOthersAlcoholUse = new TextField();
    private TextField tfNervousFeeling = new TextField();
    private TextField tfWorryingFeeling = new TextField();
    private TextField tfHopeless = new TextField();
    private TextField tfInterest = new TextField();
    private TextField tfGeneralHealth = new TextField();
    private TextField tfMouthHealth = new TextField();
    private TextField tfMisfortune = new TextField();
    private TextField tfMedicationAdherence = new TextField();
    private TextField tfAdditionalFamilyMembers = new TextField();
    
    private Button btSubmit = new Button("Submit");
    
    private GridPane gridPane = new GridPane();
    
    @Override // Override the start method int the Application class
    public void start(Stage primaryStage){
        // Create UI
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Welcome to Vivo HealthCare!"), 0, 0);
        gridPane.add(new Label("Please fill out the following form for us to better assist you!"), 0, 1);
        gridPane.add(new Label("Please enter your medical record number:"), 0, 2);
        gridPane.add(tfMedicalRecordNumber, 1, 2);
        gridPane.add(new Label("Patient's First Name:"), 0, 3);
        gridPane.add(tfPatientsFirstName, 1, 3);
        gridPane.add(new Label("Patient's Last Name:"), 0, 4);
        gridPane.add(tfPatientsLastName, 1, 4);
        gridPane.add(new Label("Patient's Date of Birth:"), 0, 5);
        gridPane.add(tfPatientsDateOfBirth, 1, 5);
        gridPane.add(new Label("Visit Coverage:"), 0, 6);
        gridPane.add(tfVisitCoverage, 1, 6);
        gridPane.add(new Label("Member Id Number:"), 0, 7);
        gridPane.add(tfMemberIdNumber, 1, 7);
        gridPane.add(new Label("Group Number:"), 0, 8);
        gridPane.add(tfGroupNumber, 1, 8);
        gridPane.add(new Label("Claim Address:"), 0, 9);
        gridPane.add(tfClaimAddress, 1, 9);
        gridPane.add(new Label("Start Date:"), 0, 10);
        gridPane.add(tfStartDate, 1, 10);
        gridPane.add(new Label("What is patient relationship to the subscriber? (1-Self/2-Child/3-Spouse)"), 0, 11);
        gridPane.add(tfPatientSubscriberRelationship, 1, 11);
        gridPane.add(new Label("Please enter subscriber's first name:"), 0, 12);
        gridPane.add(tfSubscribersFirstName, 1, 12);
        gridPane.add(new Label("Please enter subscriber's last name:"), 0, 13);
        gridPane.add(tfSubscribersLastName, 1, 13);
        gridPane.add(new Label("Subscriber's Date of Birth:"), 0, 14);
        gridPane.add(tfSubscribersDateOfBirth, 1, 14);
        gridPane.add(new Label("Are you here for a routine physical visit today? (y/n)\n" +
                 "Your physical examination is a review of your medical history, preventative \n" +
                "testing, vaccinations and screenings, and established stable conditions that \n" +
                "require no additional work up. During your physical your provider may treat \n" +
                "a condition that is new or make modifications to an existing condition. \n" +
                "Accordingly, the service would be billed for both “preventative” and \n" +
                "problem-oriented. The additional service may be subject to co pay or deductible \n" +
                "based on the insurance plan.  \n" +
                "Please address any questions you may have regarding this message."), 0, 15);
        gridPane.add(tfIsRoutineVisit, 1, 15);
        gridPane.add(tfPhysicalExaminationDescription, 0, 16);
        gridPane.add(new Label("Please enter the reason of the visit if it is not routine visit:"), 0, 17);
        gridPane.add(tfNotRoutineVisitReason, 1, 17);
        gridPane.add(new Label("Activities of Daily Living:"), 0, 18);
        gridPane.add(new Label("In the past 7 days, did you need help from others to perform everyday activities such "), 0, 19);
        gridPane.add(new Label("as eating, getting dressed, grooming, bathing, walking, or using the toilet? No/Yes"), 0, 20);
        gridPane.add(tfRegularActivities, 1, 20);
        gridPane.add(new Label("Instrumental Activities of Daily Living:"), 0, 21);
        gridPane.add(new Label("In the past 7 days, did you need help from others to take care of things such as laundry and housekeeping, banking, "), 0, 22);
        gridPane.add(new Label("shopping, using the telephone, food preparation, transportation, or taking your own medications? No/Yes"), 0, 23);
        gridPane.add(tfInstrumentalActivities, 1, 23);
        gridPane.add(new Label("ALCOHOL USE:"), 0, 24);
        gridPane.add(new Label("MEN UNDER 65 ONLY: How many times in the past year have you had 5 or more drinks in a day? on the scale 0-5"), 0, 25);
        gridPane.add(tfYangAlcoholUse, 1, 25);
        gridPane.add(new Label("ALL OTHERS: How many times in the past year have you had 4 or more drinks in a day? on the scale 0-5"), 0, 26);
        gridPane.add(tfOthersAlcoholUse, 1, 26);
        gridPane.add(new Label("ANXIETY:"), 0, 27);
        gridPane.add(new Label("a. Over the past 2 weeks, how often have you felt nervous, anxious, or on edge? "), 0, 28);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 29);
        gridPane.add(tfNervousFeeling, 1, 29);
        gridPane.add(new Label("b. Over the past 2 weeks, how often were you not able to stop worrying or control your worrying? "), 0, 30);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 31);
        gridPane.add(tfWorryingFeeling, 1, 31);
        gridPane.add(new Label("DEPRESSION:"), 0, 32);
        gridPane.add(new Label("a. Over the past 2 weeks, how often have you felt down, depressed, or hopeless? "), 0, 33);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 34);
        gridPane.add(tfHopeless, 1, 34);
        gridPane.add(new Label("b. Over the past 2 weeks, how often have you felt little interest or pleasure in doing things? "), 0, 35);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 36);
        gridPane.add(tfInterest, 1, 36);
        gridPane.add(new Label("GENERAL HEALTH:"), 0, 37);
        gridPane.add(new Label("In general, would you say your health is? Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5"), 0, 38);
        gridPane.add(tfGeneralHealth, 1, 38);
        gridPane.add(new Label("How would you describe the condition of your mouth and teeth, including false teeth or "), 0, 39);
        gridPane.add(new Label("dentures? Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5"), 0, 40);
        gridPane.add(tfMouthHealth, 1, 40);
        gridPane.add(new Label("Have you suffered a personal loss or misfortune in the last year? (For example: a job loss, disability, divorce, separation, "), 0, 41);
        gridPane.add(new Label("jail term, or the death of someone close to you.) No-1 / Yes, one serious loss-2 / Yes, tow or more serious losses-3"), 0, 42);
        gridPane.add(tfMisfortune, 1, 42);
        gridPane.add(new Label("MEDICATION ADHERENCE:"), 0, 43);
        gridPane.add(new Label("How often do you have trouble taking medicines the way you have been told to take them? "), 0, 44);
        gridPane.add(new Label("I do not have to take medicine-1"), 0, 45);
        gridPane.add(new Label("I always take them as prescribed-2"), 0, 46);
        gridPane.add(new Label("Sometimes I take them as prescribed-3"), 0, 47);
        gridPane.add(new Label("I seldom take them as prescribed-4"), 0, 48);
        gridPane.add(tfMedicationAdherence, 1, 48);
        gridPane.add(new Label("Are you checking additional family members? "), 0, 49);
        gridPane.add(new Label("Enter '0' if there is no more family members to checkin."), 0, 50);
        gridPane.add(new Label("Enter the amount of family members, if there are any."), 0, 51);
        gridPane.add(tfAdditionalFamilyMembers, 1, 51);
        
        gridPane.add(btSubmit, 1, 52);
        
        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfMedicalRecordNumber.setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientsFirstName.setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientsLastName.setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientsDateOfBirth.setAlignment(Pos.BOTTOM_RIGHT);
        tfVisitCoverage.setAlignment(Pos.BOTTOM_RIGHT);
        tfMemberIdNumber.setAlignment(Pos.BOTTOM_RIGHT);
        tfGroupNumber.setAlignment(Pos.BOTTOM_RIGHT);
        tfClaimAddress.setAlignment(Pos.BOTTOM_RIGHT);
        tfStartDate.setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientSubscriberRelationship.setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscribersFirstName.setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscribersLastName.setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscribersDateOfBirth.setAlignment(Pos.BOTTOM_RIGHT);
        tfIsRoutineVisit.setAlignment(Pos.BOTTOM_RIGHT);
        tfPhysicalExaminationDescription.setAlignment(Pos.BOTTOM_RIGHT);
        tfPhysicalExaminationDescription.setEditable(false);
        tfNotRoutineVisitReason.setAlignment(Pos.BOTTOM_RIGHT);
        tfRegularActivities.setAlignment(Pos.BOTTOM_RIGHT);
        tfInstrumentalActivities.setAlignment(Pos.BOTTOM_RIGHT);
        tfYangAlcoholUse.setAlignment(Pos.BOTTOM_RIGHT);
        tfOthersAlcoholUse.setAlignment(Pos.BOTTOM_RIGHT);
        tfNervousFeeling.setAlignment(Pos.BOTTOM_RIGHT);
        tfWorryingFeeling.setAlignment(Pos.BOTTOM_RIGHT);
        tfHopeless.setAlignment(Pos.BOTTOM_RIGHT);
        tfInterest.setAlignment(Pos.BOTTOM_RIGHT);
        tfGeneralHealth.setAlignment(Pos.BOTTOM_RIGHT);
        tfMouthHealth.setAlignment(Pos.BOTTOM_RIGHT);
        tfMisfortune.setAlignment(Pos.BOTTOM_RIGHT);
        tfMedicationAdherence.setAlignment(Pos.BOTTOM_RIGHT);
        tfAdditionalFamilyMembers.setAlignment(Pos.BOTTOM_RIGHT);
        
        GridPane.setHalignment(btSubmit, HPos.RIGHT);
        
        ScrollBar sbHorizontal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);
        
        // Create scrollpane
        ScrollPane paneForGrid = new ScrollPane();
        paneForGrid.setContent(gridPane);
        
        // Create a border pane to hold gridpane with textfields and labels.
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForGrid);
        pane.setBottom(sbHorizontal);
        pane.setRight(sbVertical);
        
        // Process events
        btSubmit.setOnAction(e -> submitApplication());
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("PatientCheckIn"); // Set title
        primaryStage.setScene(scene); //Place the scene int the stage
        primaryStage.show(); // Display the stage
    }
    
    private void submitApplication() {
        // Get values from text fields
        int medicalRecordNumber = Integer.parseInt(tfMedicalRecordNumber.getText()); 
        String patientsFirstName = tfPatientsFirstName.getText(); 
        String patientsLastName = tfPatientsLastName.getText(); 
        int patientsDateOfBirth = Integer.parseInt(tfPatientsDateOfBirth.getText()); 
        String visitCoverage = tfVisitCoverage.getText(); 
        String memberIdNumber = tfMemberIdNumber.getText(); 
        int groupNumber = Integer.parseInt(tfGroupNumber.getText()); 
        String claimAddress = tfClaimAddress.getText(); 
        String startDate = tfStartDate.getText(); 
        int patientSubscriberRelationship = Integer.parseInt(tfPatientSubscriberRelationship.getText()); 
        String subscribersFirstName = tfSubscribersFirstName.getText(); 
        String subscribersLastName = tfSubscribersLastName.getText(); 
        String subscribersDateOfBirth = tfSubscribersDateOfBirth.getText(); 
        char isRoutineVisit = tfIsRoutineVisit.getText().charAt(0); 
        String notRoutineVisitReason = tfNotRoutineVisitReason.getText(); 
        String regularActivities = tfRegularActivities.getText();
        String instrumentalActivities = tfInstrumentalActivities.getText();
        String yangAlcoholUse = tfYangAlcoholUse.getText();
        String othersAlcoholUse = tfOthersAlcoholUse.getText();
        String nervousFeeling = tfNervousFeeling.getText();
        String worryingFeeling = tfWorryingFeeling.getText();
        String hopeless = tfHopeless.getText();
        String interest = tfInterest.getText();
        String generalHealth = tfGeneralHealth.getText();
        String mouthHealth = tfMouthHealth.getText();
        String misfortune = tfMisfortune.getText();
        String medicationAdherence = tfMedicationAdherence.getText();
        int additionalFamilyMembers = Integer.parseInt(tfAdditionalFamilyMembers.getText());
        
        //*************************************************************************************/
        //The core operation of the program: back side.                                       */
        //*************************************************************************************/
        
                //print to file
        String fileName = "CheckinReport.txt";
        PrintWriter output = null;
        java.io.File file = new java.io.File(fileName);

        try{
    output = new PrintWriter(file);
}
catch(FileNotFoundException e){
    System.out.println("Error opening the file" + fileName);
    System.exit(0);
}
//patients Demography
        // Instantiate the objects for one patient.
        Patient patient =new Patient();
        Insurance insurance = new Insurance();
        VisitReason visitReason = new VisitReason();
        patient.patientDemo(output, medicalRecordNumber, patientsFirstName, patientsLastName, patientsDateOfBirth);
        // String typeofCoverage, String suscriberId, int groupNumber, String claimAddress, String startDate, int suscriberRelation, String suscriberfirstName, String suscriberlastName, String suscriberDOB
        insurance.patientCoverage(output, visitCoverage, memberIdNumber, groupNumber, claimAddress, startDate, patientSubscriberRelationship, subscribersFirstName, subscribersLastName, subscribersDateOfBirth);
        // The patient decides if it is routine or nonroutine visit.
        visitReason.decisionMaking(output, isRoutineVisit, notRoutineVisitReason);
        // Display physical examination discription
        if(isRoutineVisit == 'y')
       tfPhysicalExaminationDescription.setText(String.format(visitReason.getRoutineDiscription()));
        // Display the issue
       visitReason.displayIssues(output);
        // Assess the patient
        visitReason.performAssessement(output, regularActivities, instrumentalActivities,
            yangAlcoholUse, othersAlcoholUse, nervousFeeling, worryingFeeling, 
            hopeless, interest, generalHealth, mouthHealth, misfortune, 
            medicationAdherence);

        // Use prototype design, to clone the objects for additional family members in your household.
        Scanner input = new Scanner(System.in);
        System.out.print("Are you checking additional family members? \n" +
                          "Enter \'0\' if there is no more family members to checkin.\n" +
                          "Enter the amount of family members, if there are any: ");
        System.out.println(additionalFamilyMembers);
        
        // Creating UI objects for additional family memmbers for the doctor's checkin.
        addFamilyMember(); 
        
        ArrayList<TextField> tfMedicalRecordNumberList = new ArrayList<>();
        ArrayList<TextField> tfPatientsFirstNameList = new ArrayList<>();
        ArrayList<TextField> tfPatientsLastNameList = new ArrayList<>();
        ArrayList<TextField> tfPatientsDateOfBirthList = new ArrayList<>();
        ArrayList<TextField> tfVisitCoverageList = new ArrayList<>();
        ArrayList<TextField> tfMemberIdNumberList = new ArrayList<>();
        ArrayList<TextField> tfGroupNumberList = new ArrayList<>();
        ArrayList<TextField> tfClaimAddressList = new ArrayList<>();
        ArrayList<TextField> tfStartDateList = new ArrayList<>();
        ArrayList<TextField> tfPatientSubscriberRelationshipList = new ArrayList<>();
        ArrayList<TextField> tfSubscribersFirstNameList = new ArrayList<>();
        ArrayList<TextField> tfSubscribersLastNameList = new ArrayList<>();
        ArrayList<TextField> tfSubscribersDateOfBirthList = new ArrayList<>();
        ArrayList<TextField> tfIsRoutineVisitList = new ArrayList<>();
        ArrayList<TextField> tfPhysicalExaminationDescriptionList = new ArrayList<>();
        ArrayList<TextField> tfNotRoutineVisitReasonList = new ArrayList<>();
        ArrayList<TextField> tfRegularActivitiesList = new ArrayList<>();
        ArrayList<TextField> tfInstrumentalActivitiesList = new ArrayList<>();
        ArrayList<TextField> tfYangAlcoholUseList = new ArrayList<>();
        ArrayList<TextField> tfOthersAlcoholUseList = new ArrayList<>();
        ArrayList<TextField> tfNervousFeelingList = new ArrayList<>();
        ArrayList<TextField> tfWorryingFeelingList = new ArrayList<>();
        ArrayList<TextField> tfHopelessList = new ArrayList<>();
        ArrayList<TextField> tfInterestList = new ArrayList<>();
        ArrayList<TextField> tfGeneralHealthList = new ArrayList<>();
        ArrayList<TextField> tfMouthHealthList = new ArrayList<>();
        ArrayList<TextField> tfMisfortuneList = new ArrayList<>();
        ArrayList<TextField> tfMedicationAdherenceList = new ArrayList<>();
        
        // Get values from text fields (declare the variables - arraylist)
        ArrayList<Integer>  medicalRecordNumberList = new ArrayList<>();
        ArrayList<String> patientsFirstNameList = new ArrayList<>(); 
        ArrayList<String> patientsLastNameList = new ArrayList<>(); 
        ArrayList<Integer> patientsDateOfBirthList = new ArrayList<>();
        ArrayList<String> visitCoverageList = new ArrayList<>();
        ArrayList<String> memberIdNumberList = new ArrayList<>();
        ArrayList<Integer> groupNumberList = new ArrayList<>();
        ArrayList<String> claimAddressList = new ArrayList<>();
        ArrayList<String> startDateList = new ArrayList<>();
        ArrayList<Integer> patientSubscriberRelationshipList = new ArrayList<>();
        ArrayList<String> subscribersFirstNameList = new ArrayList<>();
        ArrayList<String> subscribersLastNameList = new ArrayList<>();
        ArrayList<String> subscribersDateOfBirthList = new ArrayList<>();
        ArrayList<Character> isRoutineVisitList = new ArrayList<>();
        ArrayList<String> notRoutineVisitReasonList = new ArrayList<>();
        ArrayList<String> regularActivitiesList = new ArrayList<>();
        ArrayList<String> instrumentalActivitiesList = new ArrayList<>();
        ArrayList<String> yangAlcoholUseList = new ArrayList<>();
        ArrayList<String> othersAlcoholUseList = new ArrayList<>();
        ArrayList<String> nervousFeelingList = new ArrayList<>();
        ArrayList<String> worryingFeelingList = new ArrayList<>();
        ArrayList<String> hopelessList = new ArrayList<>();
        ArrayList<String> interestList = new ArrayList<>();
        ArrayList<String> generalHealthList = new ArrayList<>();
        ArrayList<String> mouthHealthList = new ArrayList<>();
        ArrayList<String> misfortuneList = new ArrayList<>();
        ArrayList<String> medicationAdherenceList = new ArrayList<>();

        
        int textFieldShift = 55;
        for (int i = 0; i < additionalFamilyMembers; i++) {
        tfMedicalRecordNumberList.add(new TextField());    
        tfPatientsFirstNameList.add(new TextField());   
        tfPatientsLastNameList.add(new TextField()); 
        tfPatientsDateOfBirthList.add(new TextField());   
        tfVisitCoverageList.add(new TextField());    
        tfMemberIdNumberList.add(new TextField());   
        tfGroupNumberList.add(new TextField()); 
        tfClaimAddressList.add(new TextField());   
        tfStartDateList.add(new TextField());   
        tfPatientSubscriberRelationshipList.add(new TextField());   
        tfSubscribersFirstNameList.add(new TextField());    
        tfSubscribersLastNameList.add(new TextField());   
        tfSubscribersDateOfBirthList.add(new TextField());    
        tfIsRoutineVisitList.add(new TextField());   
        tfPhysicalExaminationDescriptionList.add(new TextField());    
        tfNotRoutineVisitReasonList.add(new TextField());   
        tfRegularActivitiesList.add(new TextField());    
        tfInstrumentalActivitiesList.add(new TextField());   
        tfYangAlcoholUseList.add(new TextField());    
        tfOthersAlcoholUseList.add(new TextField());   
        tfNervousFeelingList.add(new TextField());    
        tfWorryingFeelingList.add(new TextField());   
        tfHopelessList.add(new TextField());    
        tfInterestList.add(new TextField());   
        tfGeneralHealthList.add(new TextField());    
        tfMouthHealthList.add(new TextField());   
        tfMisfortuneList.add(new TextField());    
        tfMedicationAdherenceList.add(new TextField());  
                
        
        gridPane.add(new Label("Please fill out the form for the next family member."), 0, 1 + textFieldShift * i);
        gridPane.add(new Label("Please enter your medical record number:"), 0, 2 + textFieldShift * i);
        gridPane.add(tfMedicalRecordNumberList.get(i), 1, 2 + textFieldShift * i);
        gridPane.add(new Label("Patient's First Name:"), 0, 3 + textFieldShift * i);
        gridPane.add(tfPatientsFirstNameList.get(i), 1, 3 + textFieldShift * i);
        gridPane.add(new Label("Patient's Last Name:"), 0, 4 + textFieldShift * i);
        gridPane.add(tfPatientsLastNameList.get(i), 1, 4 + textFieldShift * i);
        gridPane.add(new Label("Patient's Date of Birth:"), 0, 5 + textFieldShift * i);
        gridPane.add(tfPatientsDateOfBirthList.get(i), 1, 5 + textFieldShift * i);
        gridPane.add(new Label("Visit Coverage:"), 0, 6 + textFieldShift * i);
        gridPane.add(tfVisitCoverageList.get(i), 1, 6 + textFieldShift * i);
        gridPane.add(new Label("Member Id Number:"), 0, 7 + textFieldShift * i);
        gridPane.add(tfMemberIdNumberList.get(i), 1, 7 + textFieldShift * i);
        gridPane.add(new Label("Group Number:"), 0, 8 + textFieldShift * i);
        gridPane.add(tfGroupNumberList.get(i), 1, 8 + textFieldShift * i);
        gridPane.add(new Label("Claim Address:"), 0, 9 + textFieldShift * i);
        gridPane.add(tfClaimAddressList.get(i), 1, 9 + textFieldShift * i);
        gridPane.add(new Label("Start Date:"), 0, 10 + textFieldShift * i);
        gridPane.add(tfStartDateList.get(i), 1, 10 + textFieldShift * i);
        gridPane.add(new Label("What is patient relationship to the subscriber? (1-Self/2-Child/3-Spouse)"), 0, 11 + textFieldShift * i);
        gridPane.add(tfPatientSubscriberRelationshipList.get(i), 1, 11 + textFieldShift * i);
        gridPane.add(new Label("Please enter subscriber's first name:"), 0, 12 + textFieldShift * i);
        gridPane.add(tfSubscribersFirstNameList.get(i), 1, 12 + textFieldShift * i);
        gridPane.add(new Label("Please enter subscriber's last name:"), 0, 13 + textFieldShift * i);
        gridPane.add(tfSubscribersLastNameList.get(i), 1, 13 + textFieldShift * i);
        gridPane.add(new Label("Subscriber's Date of Birth:"), 0, 14 + textFieldShift * i);
        gridPane.add(tfSubscribersDateOfBirthList.get(i), 1, 14 + textFieldShift * i);
        gridPane.add(new Label("Are you here for a routine visit today? (y/n)"), 0, 15 + textFieldShift * i);
        gridPane.add(tfIsRoutineVisitList.get(i), 1, 15 + textFieldShift * i);
        gridPane.add(tfPhysicalExaminationDescriptionList.get(i), 0, 16 + textFieldShift * i);
        gridPane.add(new Label("Please enter the reason of the visit if it is not routine visit:"), 0, 17 + textFieldShift * i);
        gridPane.add(tfNotRoutineVisitReasonList.get(i), 1, 17 + textFieldShift * i);
        gridPane.add(new Label("Activities of Daily Living:"), 0, 18 + textFieldShift * i);
        gridPane.add(new Label("In the past 7 days, did you need help from others to perform everyday activities such "), 0, 19 + textFieldShift * i);
        gridPane.add(new Label("as eating, getting dressed, grooming, bathing, walking, or using the toilet? No/Yes"), 0, 20 + textFieldShift * i);
        gridPane.add(tfRegularActivitiesList.get(i), 1, 20 + textFieldShift * i);
        gridPane.add(new Label("Instrumental Activities of Daily Living:"), 0, 21 + textFieldShift * i);
        gridPane.add(new Label("In the past 7 days, did you need help from others to take care of things such as laundry and housekeeping, banking, "), 0, 22 + textFieldShift * i);
        gridPane.add(new Label("shopping, using the telephone, food preparation, transportation, or taking your own medications? No/Yes"), 0, 23 + textFieldShift * i);
        gridPane.add(tfInstrumentalActivitiesList.get(i), 1, 23 + textFieldShift * i);
        gridPane.add(new Label("ALCOHOL USE:"), 0, 24 + textFieldShift * i);
        gridPane.add(new Label("MEN UNDER 65 ONLY: How many times in the past year have you had 5 or more drinks in a day? on the scale 0-5"), 0, 25 + textFieldShift * i);
        gridPane.add(tfYangAlcoholUseList.get(i), 1, 25 + textFieldShift * i);
        gridPane.add(new Label("ALL OTHERS: How many times in the past year have you had 4 or more drinks in a day? on the scale 0-5"), 0, 26 + textFieldShift * i);
        gridPane.add(tfOthersAlcoholUseList.get(i), 1, 26 + textFieldShift * i);
        gridPane.add(new Label("ANXIETY:"), 0, 27 + textFieldShift * i);
        gridPane.add(new Label("a. Over the past 2 weeks, how often have you felt nervous, anxious, or on edge? "), 0, 28 + textFieldShift * i);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 29 + textFieldShift * i);
        gridPane.add(tfNervousFeelingList.get(i), 1, 29 + textFieldShift * i);
        gridPane.add(new Label("b. Over the past 2 weeks, how often were you not able to stop worrying or control your worrying? "), 0, 30 + textFieldShift * i);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 31 + textFieldShift * i);
        gridPane.add(tfWorryingFeelingList.get(i), 1, 31 + textFieldShift * i);
        gridPane.add(new Label("DEPRESSION:"), 0, 32 + textFieldShift * i);
        gridPane.add(new Label("a. Over the past 2 weeks, how often have you felt down, depressed, or hopeless? "), 0, 33 + textFieldShift * i);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 34 + textFieldShift * i);
        gridPane.add(tfHopelessList.get(i), 1, 34 + textFieldShift * i);
        gridPane.add(new Label("b. Over the past 2 weeks, how often have you felt little interest or pleasure in doing things? "), 0, 35 + textFieldShift * i);
        gridPane.add(new Label("Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3"), 0, 36 + textFieldShift * i);
        gridPane.add(tfInterestList.get(i), 1, 36 + textFieldShift * i);
        gridPane.add(new Label("GENERAL HEALTH:"), 0, 37 + textFieldShift * i);
        gridPane.add(new Label("In general, would you say your health is? Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5"), 0, 38 + textFieldShift * i);
        gridPane.add(tfGeneralHealthList.get(i), 1, 38 + textFieldShift * i);
        gridPane.add(new Label("How would you describe the condition of your mouth and teeth, including false teeth or "), 0, 39 + textFieldShift * i);
        gridPane.add(new Label("dentures? Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5"), 0, 40 + textFieldShift * i);
        gridPane.add(tfMouthHealthList.get(i), 1, 40 + textFieldShift * i);
        gridPane.add(new Label("Have you suffered a personal loss or misfortune in the last year? (For example: a job loss, disability, divorce, separation, "), 0, 41 + textFieldShift * i);
        gridPane.add(new Label("jail term, or the death of someone close to you.) No-1 / Yes, one serious loss-2 / Yes, tow or more serious losses-3"), 0, 42 + textFieldShift * i);
        gridPane.add(tfMisfortuneList.get(i), 1, 42 + textFieldShift * i);
        gridPane.add(new Label("MEDICATION ADHERENCE:"), 0, 43 + textFieldShift * i);
        gridPane.add(new Label("How often do you have trouble taking medicines the way you have been told to take them? "), 0, 44 + textFieldShift * i);
        gridPane.add(new Label("I do not have to take medicine-1"), 0, 45 + textFieldShift * i);
        gridPane.add(new Label("I always take them as prescribed-2"), 0, 46 + textFieldShift * i);
        gridPane.add(new Label("Sometimes I take them as prescribed-3"), 0, 47 + textFieldShift * i);
        gridPane.add(new Label("I seldom take them as prescribed-4"), 0, 48 + textFieldShift * i);
        gridPane.add(tfMedicationAdherenceList.get(i), 1, 48 + textFieldShift * i);
        System.out.println("Array list check after adding textfields to the gridpane for the second person.");
        // Set properties for UI
        tfMedicalRecordNumberList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientsFirstNameList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientsLastNameList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientsDateOfBirthList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfVisitCoverageList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfMemberIdNumberList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfGroupNumberList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfClaimAddressList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfStartDateList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfPatientSubscriberRelationshipList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscribersFirstNameList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscribersLastNameList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscribersDateOfBirthList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfIsRoutineVisitList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfPhysicalExaminationDescriptionList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfPhysicalExaminationDescriptionList.get(i).setEditable(false);
        tfNotRoutineVisitReasonList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfRegularActivitiesList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfInstrumentalActivitiesList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfYangAlcoholUseList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfOthersAlcoholUseList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfNervousFeelingList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfWorryingFeelingList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfHopelessList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfInterestList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfGeneralHealthList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfMouthHealthList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfMisfortuneList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        tfMedicationAdherenceList.get(i).setAlignment(Pos.BOTTOM_RIGHT);
        
            // Get values from text fields
        medicalRecordNumberList.set(i, Integer.parseInt(tfMedicalRecordNumberList.get(i).getText())); 
        patientsFirstNameList.set(i, tfPatientsFirstNameList.get(i).getText());
        patientsLastNameList.set(i, tfPatientsLastNameList.get(i).getText());
        patientsDateOfBirthList.set(i, Integer.parseInt(tfPatientsDateOfBirthList.get(i).getText()));
        visitCoverageList.set(i, tfVisitCoverageList.get(i).getText());
        memberIdNumberList.set(i, tfMemberIdNumberList.get(i).getText());
        groupNumberList.set(i, Integer.parseInt(tfGroupNumberList.get(i).getText()));
        claimAddressList.set(i, tfClaimAddressList.get(i).getText());
        startDateList.set(i, tfStartDateList.get(i).getText());
        patientSubscriberRelationshipList.set(i, Integer.parseInt(tfPatientSubscriberRelationshipList.get(i).getText()));
        subscribersFirstNameList.set(i, tfSubscribersFirstNameList.get(i).getText());
        subscribersLastNameList.set(i, tfSubscribersLastNameList.get(i).getText());
        subscribersDateOfBirthList.set(i, tfSubscribersDateOfBirthList.get(i).getText());
        isRoutineVisitList.set(i, tfIsRoutineVisitList.get(i).getText().charAt(0));
        notRoutineVisitReasonList.set(i, tfNotRoutineVisitReasonList.get(i).getText());
        regularActivitiesList.set(i, tfRegularActivitiesList.get(i).getText());
        instrumentalActivitiesList.set(i, tfInstrumentalActivitiesList.get(i).getText());
        yangAlcoholUseList.set(i, tfYangAlcoholUseList.get(i).getText());
        othersAlcoholUseList.set(i, tfOthersAlcoholUseList.get(i).getText());
        nervousFeelingList.set(i, tfNervousFeelingList.get(i).getText());
        worryingFeelingList.set(i, tfWorryingFeelingList.get(i).getText());
        hopelessList.set(i, tfHopelessList.get(i).getText());
        interestList.set(i, tfInterestList.get(i).getText());
        generalHealthList.set(i, tfGeneralHealthList.get(i).getText());
        mouthHealthList.set(i, tfMouthHealthList.get(i).getText());
        misfortuneList.set(i, tfMisfortuneList.get(i).getText());
        medicationAdherenceList.set(i, tfMedicationAdherenceList.get(i).getText());
        }
        
        // Creating regular objects for additional family members during checkin.
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Insurance> insuranceList = new ArrayList<>();
        ArrayList<VisitReason> visitReasonList = new ArrayList<>();
        for (int i = 0; i < additionalFamilyMembers; i++) {
            patientList.add((Patient)patient.clone());
            insuranceList.add((Insurance)insurance.clone());
            visitReasonList.add((VisitReason)visitReason.clone());
            patientList.get(i).patientDemo(output, medicalRecordNumberList.get(i), patientsFirstNameList.get(i), patientsLastNameList.get(i), patientsDateOfBirthList.get(i));
            insuranceList.get(i).patientCoverage(output, visitCoverageList.get(i), memberIdNumberList.get(i), groupNumberList.get(i), claimAddressList.get(i), startDateList.get(i), patientSubscriberRelationshipList.get(i), subscribersFirstNameList.get(i), subscribersLastNameList.get(i), subscribersDateOfBirthList.get(i));
            // The patient decides if it is routine or nonroutine visit.
            visitReasonList.get(i).decisionMaking(output, isRoutineVisitList.get(i), notRoutineVisitReasonList.get(i));
            // Display the issue
            visitReasonList.get(i).displayIssues(output);
            // Assess the patient
            visitReasonList.get(i).performAssessement(output, regularActivitiesList.get(i), instrumentalActivitiesList.get(i),
                yangAlcoholUseList.get(i), othersAlcoholUseList.get(i), nervousFeelingList.get(i), worryingFeelingList.get(i), 
                hopelessList.get(i), interestList.get(i), generalHealthList.get(i), mouthHealthList.get(i), misfortuneList.get(i), 
                medicationAdherenceList.get(i));
        }

        output.close();

        System.out.println("Application is finished working here. ");
    }
    
    private void addFamilyMember(){
        System.out.println("Family Member is added");
    }
    
    
}
