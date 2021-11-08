/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0063;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
    Scanner sc = new  Scanner(System.in);
    
    public double checkDouble(String mess, double min, double max) {
        double result;
        
        while (true) {
            try {
                System.out.print(mess);
                result = Double.parseDouble(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.println("Between " + min + " and " + max + ".");
                    System.out.print("Try again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Must enter a real number ! ");
            }
        }
        return result;
    }
    
    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }
    
      public String  checkFormatString(String mess,String parternFomart){
       String result;
       while(true){
           System.out.print(mess);
           result=checkInputString();
           if (result.matches(parternFomart)) {
               break;
           }else{
               System.err.println("Wrong format bruh!!!");
              
           }
       }
       return result;
    }
}
