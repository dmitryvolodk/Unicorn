
import java.util.Scanner;

public class Insurance implements Cloneable{

private String suscriberfirstName;
    private String suscriberlastName;
    private String suscriberId;
    private String typeofCoverage;
    private int groupNumber;
    private String claimAddress;
    private String startDate;
    private String suscriberDOB;
    private int suscriberRelation;


    public Insurance(){
    }
    public void patientCoverage(java.io.PrintWriter output) {
        Scanner input = new Scanner(System.in);
        System.out.println("Visit coverage:  ");
        typeofCoverage = input.next();
        System.out.println(" Member Id number:  ");
        suscriberId = input.next();
        System.out.println(" Group number:  ");
        groupNumber = input.nextInt();
        System.out.println(" Claim Address:  ");
        claimAddress = input.next();
        System.out.println("Start Date: ");
        startDate = input.next();
        System.out.println("What is patient relationship to the suscriber?     1-Self/2-Child/3-Spouse");
        suscriberRelation = input.nextInt();
        if (suscriberRelation == 1) {
            System.out.println(" Patient is the subscriber"); }
         else {
            System.out.println(" Please enter subscribe first name: ");
            suscriberfirstName = input.next();
            System.out.println(" Please enter subscriber last name: ");
            suscriberlastName = input.next();
            System.out.println(" Please enter subscriber Date of Birth ");
            suscriberDOB = input.next();
        }
      //print to file
            output.println ("Visit coverage:  "+ typeofCoverage);
            output.println(" Member Id number:  " +suscriberId);
            output.println(" Group number:  " +groupNumber);
            output.println(" Claim Address:  " + claimAddress);
            output.println("Start Date: " + startDate);
            output.println("What is patient relationship to the subscriber?     1-Self/2-Child/3-Spouse" + suscriberRelation);
             if (suscriberRelation == 1) {
                 output.println(" Patient is the subscriber");
             }  else {
                 output.println(" Please enter subscribe first name: "+suscriberfirstName);
                 output.println(" Please enter subscriber last name: " + suscriberlastName);
                 output.println(" Please enter subscriber Date of Birth " + suscriberDOB);


             }
    }
    public String getSuscriberfirstName() {
        return suscriberfirstName;
    }

    public String getSuscriberlastName() {
        return suscriberlastName;
    }

    public String getSuscriberId() {
        return suscriberId;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getClaimAddress() {
        return claimAddress;
    }

    public String getSuscriberDOB() {
        return suscriberDOB;
    }

    // Override the protected clone method defined in the Object class, and strengthen its accessibility.
    @Override
    public Object clone(){
        try{
            // Perform a shallow copy
            Insurance insuranceClone = (Insurance)super.clone();
            return insuranceClone;
        }
        catch(CloneNotSupportedException ex){
            return null;
        }
    }

}