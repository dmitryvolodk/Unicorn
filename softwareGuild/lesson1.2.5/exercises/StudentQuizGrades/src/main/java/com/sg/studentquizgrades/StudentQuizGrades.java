package com.sg.studentquizgrades;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentQuizGrades {
    public static void main(String[] args){
        UserIOInterface myUserIO = new UserIO();
        Scanner myScanner = new Scanner(System.in);
        HashMap<String, Score> students = new HashMap<>();
        
        Integer operation = 0;
        String operationString = "";
        String studentName = "";
        Score score = new Score();
        Integer sum = 0,
                count = 0,
                maxScore = 0,
                minScore = 0;
        String promptMenu = "\nPlease choose an option from the following menu:\n"
                    + "\'0\' - exit the program\n"
                    + "\'1\' - view a list of students in the system\n"
                    + "\'2\' - add a student to the system\n"
                    + "\'3\' - remove a student from the system\n"
                    + "\'4\' - view a list of quiz scores for a given student\n"
                    + "\'5\' - view the average quiz score for a given student\n"
                    + "\'6\' - calculate the average quiz score for the entire class\n"
                    + "\'7\' - find and list the student(s) with the highest quiz score\n"
                    + "\'8\' - find and list the student(s) with the lowest quiz score\n";
        String promptAddName = "Enter student name to add:";
        String promptAddScore = "Enter student score or \'stop\' to stop entering:";
        String promptRemoveName = "Enter student name to remove:";
        String promptNameViewScores = "Enter student name to view scores:";
        String promptNameViewAverageScore = "Enter student name to view an average score:";
        
        do{
            myUserIO.print(promptMenu);
            
            operationString = myScanner.nextLine();
            operation = Integer.parseInt(operationString);
            if(operation == 0){
                break;
            }
            Set<String> keys = students.keySet();
            
            switch(operation){
                case 1: System.out.println("\nLIST OF STUDENTS: \n==================");
                        for(String k : keys){
                            System.out.println(k);
                        }
                        break;
                case 2: studentName = myUserIO.readString(promptAddName);
                        operationString = myUserIO.readString(promptAddScore);
                        
                        if(!(operationString.equalsIgnoreCase("stop"))){
                            score = new Score();
                        }
                        Integer counter = 0;
                        do{
                            if(counter != 0){
                                operationString = myScanner.nextLine();
                            }
                            if(operationString.equalsIgnoreCase("stop")){
                                break;
                            }
                            operation = Integer.parseInt(operationString);
                            score.setScore(operation);
                            counter++;
                        }while(!(operationString.equalsIgnoreCase("stop")));
                        
                        students.put(studentName, score);
                        break;
                case 3: studentName = myUserIO.readString(promptRemoveName);
                        students.remove(studentName);
                        System.out.println(studentName + " was removed");
                        break;
                case 4: studentName = myUserIO.readString(promptNameViewScores);
                        students.get(studentName).printStudentScoresList();
                        break;
                case 5: studentName = myUserIO.readString(promptNameViewAverageScore);
                        System.out.println(students.get(studentName).getEverageStudentScore());
                        break;
                case 6: sum = 0;
                        count = 0;
                        for(String k : keys){
                            for(int i = 0; i < students.get(k).getStudentScoresList().size(); i++){
                                sum += Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString());
                                count++;
                            }
                        }
                        System.out.println("Average class score: " + ((float)sum / (float)count));
                        break;
                case 7: maxScore = Integer.parseInt(students.get(studentName).getStudentScoresList().get(0).toString());
                        for(String k : keys){
                            for(int i = 0; i < students.get(k).getStudentScoresList().size(); i++){
                                
                                if(maxScore < Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString())){
                                    maxScore = Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString());
                                }
                            }
                        }
                        System.out.println("Highest score: " + maxScore);
                        for(String k : keys){
                            for(int i = 0; i < students.get(k).getStudentScoresList().size(); i++){
                                if(maxScore == Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString())){
                                    System.out.println("for student: " + k);
                                    students.get(k);
                                }
                            }
                        }
                        break;
                case 8: minScore = Integer.parseInt(students.get(studentName).getStudentScoresList().get(0).toString());
                        for(String k : keys){
                            for(int i = 0; i < students.get(k).getStudentScoresList().size(); i++){
                                if(minScore > Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString())){
                                    minScore = Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString());
                                }
                            }
                        }
                        System.out.println("Lowest score: " + minScore);
                        for(String k : keys){
                            for(int i = 0; i < students.get(k).getStudentScoresList().size(); i++){
                                if(minScore == Integer.parseInt(students.get(k).getStudentScoresList().get(i).toString())){
                                    System.out.println("for student: " + k);
                                    students.get(k);
                                }
                            }
                        }
                        break;
            }
            
        }while(operation != 0);
        
        System.out.println("Good bye!");
    }
}
