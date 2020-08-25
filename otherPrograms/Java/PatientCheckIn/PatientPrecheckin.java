public interface PatientPrecheckin {

    public void decisionMaking(java.io.PrintWriter output, char routine, String issues);
    
    public void routineVisit();
    public void nonRoutineVisit(java.io.PrintWriter output, String issues);
    public void displayIssues(java.io.PrintWriter output);
    
    public void performAssessement(java.io.PrintWriter output, String assessRegularActivities, String assessInstrumentalActivities,
            String assessYangAlcoholUse, String assessOthersAlcoholUse, String assessNervousFeeling, String assessWorryingFeeling, 
            String assessHopeless, String assessInterest, String assessGeneralHealth, String assessMouthHealth, String assessMisfortune, 
            String assessMedicationAdherence);


}
