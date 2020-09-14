package com.sg.shapesandperimeters;

public class Square extends Shape {
    private double area;
    private double perimeter;
    private double side;
    
    @Override
    public void getArea(){
        area = side * side;
        System.out.println(area);
    }
    
    @Override
    public void getPerimeter(){
        perimeter = side * 4;
        System.out.println(perimeter);
    }
}
