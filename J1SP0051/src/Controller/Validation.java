/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public final class Validation {
    
    private final static Scanner sc = new Scanner(System.in);
    
     public static int checkInt(String mess, int min, int max) { //check data type int in this case is choice
        int number;
        while (true) {// loop until  true/return
            System.out.print(mess); // show the message/ title you want
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) { // if in valid rage 
                    return number;
                } else {  // out of valid rage / in-valid rage
                    System.err.println("Number must in rage " + min + " to " + max); // show warning error
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! "); // show warning exception
            }
        }

    }
     
      public static double checkDouble(String mess, double min, double max) { //check data type int in this case is choice
        double number;
        while (true) {// loop until  true/return
            System.out.print(mess); // show the message/ title you want
            try {
                number = Double.parseDouble(sc.nextLine().trim());
                if (number >= min && number <= max) { // if in valid rage 
                    return number;
                } else {  // out of valid rage / in-valid rage
                    System.err.println("Number must in rage " + min + " to " + max); // show warning error
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! "); // show warning exception
            }
        }

    }
      
      
     public static String CheckOperator(String message){
         String operator;
         while(true){
             System.out.print(message);
             operator = sc.nextLine().trim();
             if(operator.matches("[+-/^=]{1}")|| operator.equalsIgnoreCase("*")){
                 return operator;
             }else{
                 System.out.print("Please input (+, -, *, /, ^)");
             }
         }
         
     }
     
}
