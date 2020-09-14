package com.sg.shapesandperimeters;

public class Circle extends Shape{
    private double area;
    private double perimeter;
    private double radius;
    
    @Override
    public void getArea(){
        area = Math.PI * radius * radius;
        System.out.println(area);
    }
    
    @Override
    public void getPerimeter(){
        perimeter = 2 * Math.PI * radius;
        System.out.println(perimeter);
    }
}
