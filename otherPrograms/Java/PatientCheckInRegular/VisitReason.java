import java.util.Scanner;
import java.awt.*;

public class VisitReason implements PatientPrecheckin,Cloneable {

    private char routine;
    private String issues;
    private String assessement;
    Scanner input = new Scanner(System.in);

    public VisitReason() {
    }

    public String getIssues() {
        return issues;
    }

    public void decisionMaking(java.io.PrintWriter output){
        System.out.println("Are you here for a routine visit today? y/n ");
        routine = input.next().charAt(0);

        if(routine == 'y'){
            routineVisit();
        }
        else{
            nonRoutineVisit(output);
        }

    }

    public void routineVisit(){
        System.out.println("Your physical examination is a review of your medical history, preventative \n" +
                "testing, vaccinations and screenings, and established stable conditions that \n" +
                "require no additional work up. During your physical your provider may treat \n" +
                "a condition that is new or make modifications to an existing condition. \n" +
                "Accordingly, the service would be billed for both “preventative” and \n" +
                "problem-oriented. The additional service may be subject to co pay or deductible \n" +
                "based on the insurance plan.  \n" +
                "Please address any questions you may have regarding this message.");
    }

    public void nonRoutineVisit(java.io.PrintWriter output){
        System.out.println("Please enter the reason why you are here today: ");
        output.println("Please enter the reason why you are here today: ");
        issues = input.next();
    }

    public void displayIssues(java.io.PrintWriter output){
        output.println(issues);
    }

    public void performAssessement(java.io.PrintWriter output){
        System.out.println("Please answer the following assessment questions to help the doctor with the visit. \n");
        System.out.println("Activities of Daily Living:");
        System.out.println("In the past 7 days, did you need help from others to perform everyday activities such " +
                           "as eating, getting dressed, grooming, bathing, walking, or using the toilet? No/Yes");
        assessement = input.next();

        /* File output */
        output.println("Please answer the following assessment questions to help the doctor with the visit. ");
        output.println();
        output.println("Activities of Daily Living:");
        output.println("In the past 7 days, did you need help from others to perform everyday activities such " +
                "as eating, getting dressed, grooming, bathing, walking, or using the toilet? No/Yes");
        output.println(assessement);
        /* File output */

        System.out.println("\nInstrumental Activities of Daily Living:");
        System.out.println("In the past 7 days, did you need help from others to take care of things such as laundry " +
                           "and housekeeping, banking, shopping, using the telephone, food preparation, transportation, " +
                           "or taking your own medications? No/Yes");
        assessement = input.next();

        /* File output */
        output.println();
        output.println("Instrumental Activities of Daily Living:");
        output.println("In the past 7 days, did you need help from others to take care of things such as laundry " +
                "and housekeeping, banking, shopping, using the telephone, food preparation, transportation, " +
                "or taking your own medications? No/Yes");
        output.println(assessement);
        /* File output */

        System.out.println("\nALCOHOL USE:");
        System.out.println("MEN UNDER 65 ONLY: How many times in the past year have you had 5 or more drinks in a day?" +
                          " on the scale 0-5");
        assessement = input.next();

        /* File output */
        output.println();
        output.println("ALCOHOL USE:");
        output.println("MEN UNDER 65 ONLY: How many times in the past year have you had 5 or more drinks in a day?" +
                " on the scale 0-5");
        output.println(assessement);
        /* File output */

        System.out.println("ALL OTHERS: How many times in the past year have you had 4 or more drinks in a day?" +
                          " on the scale 0-5");
        assessement = input.next();

        /* File output */
        output.println("ALL OTHERS: How many times in the past year have you had 4 or more drinks in a day?" +
                " on the scale 0-5");
        output.println(assessement);
        /* File output */

        System.out.println("\nANXIETY:");
        System.out.println("a. Over the past 2 weeks, how often have you felt nervous, anxious, or on edge?" +
                          " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        assessement = input.next();

        /* File output */
        output.println();
        output.println("ANXIETY:");
        output.println("a. Over the past 2 weeks, how often have you felt nervous, anxious, or on edge?" +
                " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        output.println(assessement);
        /* File output */

        System.out.println("b. Over the past 2 weeks, how often were you not able to stop worrying or control your worrying?" +
                          " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        assessement = input.next();

        /* File output */
        output.println("b. Over the past 2 weeks, how often were you not able to stop worrying or control your worrying?" +
                " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        output.println(assessement);
        /* File output */

        System.out.println("\nDEPRESSION:");
        System.out.println("a. Over the past 2 weeks, how often have you felt down, depressed, or hopeless?" +
                " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        assessement = input.next();

        /* File output */
        output.println();
        output.println("DEPRESSION:");
        output.println("a. Over the past 2 weeks, how often have you felt down, depressed, or hopeless?" +
                " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        output.println(assessement);
        /* File output */

        System.out.println("b. Over the past 2 weeks, how often have you felt little interest or pleasure in doing things?" +
                " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        assessement = input.next();

        /* File output */
        output.println("b. Over the past 2 weeks, how often have you felt little interest or pleasure in doing things?" +
                " Not all-0 / Several days-1 / More days than not-2 / Nearly every day-3");
        output.println(assessement);
        /* File output */

        System.out.println("\nGENERAL HEALTH:");
        System.out.println("In general, would you say your health is?" +
                " Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5");
        assessement = input.next();

        /* File output */
        output.println();
        output.println("GENERAL HEALTH:");
        output.println("In general, would you say your health is?" +
                " Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5");
        output.println(assessement);
        /* File output */

        System.out.println("How would you describe the condition of your mouth and teeth, including false teeth or dentures?" +
                " Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5");
        assessement = input.next();

        /* File output */
        output.println("How would you describe the condition of your mouth and teeth, including false teeth or dentures?" +
                " Excellent-1 / Very good-2 / Good-3 / Fair-4 / Poor-5");
        output.println(assessement);
        /* File output */

        System.out.println("Have you suffered a personal loss or misfortune in the last year? (For example: a job loss, " +
                "disability, divorce, separation, jail term, or the death of someone close to you.)" +
                " No-1 / Yes, one serious loss-2 / Yes, tow or more serious losses-3");
        assessement = input.next();

        /* File output */
        output.println("Have you suffered a personal loss or misfortune in the last year? (For example: a job loss, " +
                "disability, divorce, separation, jail term, or the death of someone close to you.)" +
                " No-1 / Yes, one serious loss-2 / Yes, tow or more serious losses-3");
        output.println(assessement);
        /* File output */

        System.out.println("\nMEDICATION ADHERENCE:");
        System.out.println("How often do you have trouble taking medicines the way you have been told to take them? \n" +
                " I do not have to take medicine-1 \n " +
                 "I always take the as prescribed-2 \n " +
                  "Sometimes I take them as prescribed-3 \n" +
                " I seldom take them as prescribed-4");
        assessement = input.next();

        /* File output */
        output.println();
        output.println("MEDICATION ADHERENCE:");
        output.println("How often do you have trouble taking medicines the way you have been told to take them? ");
        output.println(" I do not have to take medicine-1 ");
        output.println("I always take the as prescribed-2 ");
        output.println("Sometimes I take them as prescribed-3 ");
        output.println(" I seldom take them as prescribed-4");
        output.println(assessement);
        /* File output */
    }

    // Override the protected clone method defined in the Object class, and strengthen its accessibility.
    @Override
    public Object clone(){
        try{
            // Perform a shallow copy
            VisitReason visitReasonClone = (VisitReason)super.clone();
            return visitReasonClone;
        }
        catch(CloneNotSupportedException ex){
            return null;
        }
    }


}

