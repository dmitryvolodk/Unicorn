/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowmaster;

/**
 *
 * @author dmitryvolodk
 */
import java.util.Scanner;

public class Window {
    /**
     * Entry point to my program
     * @param args arguments passed in from command line
     */
    public static void main(String[] args){
    // Declare height and width of the window
    float height;
    float width;
    
    // Declare  the string height and width
    String stringHeight;
    String stringWidth;
    
    // Declare the area and the perimeter of the window
    float area;
    float perimeter;
    
    // Declare window, trim, and the total cost.
    float windowCost;
    float trimCost;
    float cost;
    
    // Declare and initialize the scanner object to use for the user's input
    Scanner myScanner = new Scanner(System.in);
    
    // Promt the user to enter the height of the window
    System.out.println("Please enter the height of the window in feet: ");
    
    // Read user's height input and assign the value to the string height variable
    stringHeight = myScanner.nextLine();
    
    // Promt the user to enter the width of the window
    System.out.println("Please enter the width of the window in feet: ");
    
    // Read user's width input and assign the value to the string width variable
    stringWidth = myScanner.nextLine();
    
    // Convert the string values of height and width into float values and assign them tofloat variables
    height = Float.parseFloat(stringHeight);
    width = Float.parseFloat(stringWidth);
    
    // Calculate the area of the window
    area = height * width;
    
    // Calculate the perimeter of the trim
    perimeter = 2 * (height + width);
    
    // Calculate the window cost
    windowCost = 3.50f * area;
    
    // Calculate the trim cost
    trimCost = 2.25f * perimeter;
    
    // Calculate the total cost of the windo
    cost = windowCost + trimCost;
    
    // Display heigh, width, area, perimeter, and the cost to the user
    System.out.println("Window height = " + height);
    System.out.println("Window width = " + height);
    System.out.println("Window area = " + area);
    System.out.println("Window perimeter = " + perimeter);
    System.out.println("Total cost = " + cost);
    }
}
