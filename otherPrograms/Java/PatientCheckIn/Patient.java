import java.util.Scanner;

public class Patient extends PatientCheckin implements Cloneable{


    private String patientsfirstName;
    private String patientslastName;
    private int patientsDOB;
    private int mrn;
    //Constructor
    public Patient(){

    }
    public void patientDemo(java.io.PrintWriter output, int mrn, String patientsfirstName, String patientslastName, int patientsDOB) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Welcome to VIVO HealthCare!");
        System.out.println(" Please fill out the following form in oder for us to better assist you!");
        System.out.println("Please enter your medical reccord number:  ");
        //mrn = input.nextInt();
        System.out.println("Patient's First name:  ");
        //patientsfirstName = input.next();
        patientsfirstName = patientsfirstName.replaceAll("[^a-zA-Z]", "");
        System.out.println("Patient's last name: ");
        //patientslastName = input.next();
        patientslastName = patientslastName.replaceAll("[^a-zA-Z]", "");
        System.out.println(" Patient's Date of Birth:  ");
        //patientsDOB = input.nextInt();

        //output to file
        output.println(" Welcome to VIVO HealthCare!");
        output.println(" Please fill out the following form in oder for us to better assist you!");
        output.println("Please enter your medical reccord number:  " + mrn);
        output.println("Patient's First name:  " + patientsfirstName);
        output.println("Patient's last name:  " + patientslastName);
        output.println(" Patient's Date of Birth:  " + patientsDOB);
    }
    
    public String getPatientsfirstName() {
        return patientsfirstName;
    }

    public String getPatientslastName() {
        return patientslastName;
    }

    @Override
    public int getMrn() {
        return mrn;
    }

    // Override the protected clone method defined in the Object class, and strengthen its accessibility.
    @Override
    public Object clone(){
        try{
            // Perform a shallow copy
            Patient patientClone = (Patient)super.clone();
            return patientClone;
        }
        catch(CloneNotSupportedException ex){
            return null;
        }
    }


}
