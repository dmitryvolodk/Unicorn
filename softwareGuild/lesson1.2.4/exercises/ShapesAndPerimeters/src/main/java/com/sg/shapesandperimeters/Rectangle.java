package com.sg.shapesandperimeters;

public class Rectangle extends Shape {
    private double area;
    private double perimeter;
    private double sideOne;
    private double sideTwo;
    
    @Override
    public void getArea(){
        area = sideOne * sideTwo;
        System.out.println(area);
    }
    
    @Override
    public void getPerimeter(){
        perimeter = (sideOne + sideTwo) * 2;
        System.out.println(perimeter);
    }
}
