/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h202;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Manager {
     private  Scanner sc = new Scanner(System.in);

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
    
    public void printReverse(){
        System.out.print("Enter your string: ");
        String input = checkInputString();  //phuc
       String result ="";
       
        for (int i = 0; i < input.length(); i++) {
            result+= input.charAt( input.length()-1-i);
           
          
             
        }
        
        System.out.println(result);
            
        }
    
    
    
    }
    
    
    

