package com.sg.shapesandperimeters;

public class Triangle extends Shape {
    private double area;
    private double sideOne,
            sideTwo,
            sideThree;
    private double perimeter;
    
    @Override
    public void getPerimeter(){
        perimeter = sideOne + sideTwo + sideThree;
        System.out.println(perimeter);
    }
    
    @Override
    public void getArea(){
        double halfPerimeter = 0.5 * perimeter;
        area = Math.sqrt(halfPerimeter * (halfPerimeter - sideOne) * (halfPerimeter - sideTwo) * (halfPerimeter - sideThree));
        System.out.println(area);
    }
}
