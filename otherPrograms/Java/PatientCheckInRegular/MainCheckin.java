
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class MainCheckin {

    public static void main(String[] args) {
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
        patient.patientDemo(output);
        insurance.patientCoverage(output);
        // The patient decides if it is routine or nonroutine visit.
        visitReason.decisionMaking(output);
        // Display the issue
       visitReason.displayIssues(output);
        // Assess the patient
        visitReason.performAssessement(output);

        // Use prototype design, to clone the objects for additional family members in your household.
        Scanner input = new Scanner(System.in);
        System.out.print("Are you checking additional family members? \n" +
                          "Enter \'0\' if there is no more family members to checkin.\n" +
                          "Enter the amount of family members, if there are any.\n");
        int patientNumber = input.nextInt();
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Insurance> insuranceList = new ArrayList<>();
        ArrayList<VisitReason> visitReasonList = new ArrayList<>();
        for (int i = 0; i < patientNumber; i++) {
            patientList.add((Patient)patient.clone());
            insuranceList.add((Insurance)insurance.clone());
            visitReasonList.add((VisitReason)visitReason.clone());
            patientList.get(i).patientDemo(output);
            insuranceList.get(i).patientCoverage(output);
            // The patient decides if it is routine or nonroutine visit.
            visitReasonList.get(i).decisionMaking(output);
            // Display the issue
            visitReasonList.get(i).displayIssues(output);
            // Assess the patient
            visitReasonList.get(i).performAssessement(output);
        }

        output.close();
    }
}

