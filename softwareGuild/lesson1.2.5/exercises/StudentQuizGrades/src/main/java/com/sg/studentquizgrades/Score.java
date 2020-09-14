package com.sg.studentquizgrades;

import java.util.ArrayList;

public class Score {
    ArrayList<Integer> studentScoresList = new ArrayList<>();
    
    private float everageStudentScore;

    public void setScore(Integer score) {
        this.studentScoresList.add(score);
    }
    
    public ArrayList getStudentScoresList(){
        return studentScoresList;
    }
    
    public void printStudentScoresList() {
        for(Integer s : studentScoresList){
            System.out.println(s);
        }
    }

    public float getEverageStudentScore() {
        Integer sum = 0;
        for(Integer s : studentScoresList){
            sum = sum + s;
        }
        everageStudentScore = (float)sum / (float)studentScoresList.size();
        return everageStudentScore;
    }
}
