package com.sg.shapesandperimeters;

public abstract class Shape {
    private String color;
    
    public void getArea(){
    }
    
    public void getPerimeter(){
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
}
