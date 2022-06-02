/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0070;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
      private final  Scanner sc = new Scanner(System.in);
      
   

    
    public int checkInt(String mess, int min, int max) {
        int result  ;
        while (true) {
            System.out.print(mess);
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.println("Out of range! Please input in range "
                            + "[" + min + ", " + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
                System.out.print("Try again: ");
            }
        }
        return result;
    }

  
    public String checkInputString() {        
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.print("Not empty. Enter again: ");
            } else {
                return result;
            }
        }
    }

    public void checkAccNumber(ResourceBundle rb) {
        while (true) {
           
            System.out.print(rb.getString("account")); 
            String account = checkInputString();
            if (account.matches("[0-9]{10}")) {
                break;
            } else {
                System.err.println(rb.getString("wrong.account"));
            }
        }
    }

    public void checkPass(ResourceBundle rb) { // * = {0,1} ;+ = {1,} aka 1 to many
//        String length = "[a-zA-Z0-9]{8,31}"; // must alphanumberic length 8-31 character
//        String digit = "[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*";   // must exist at least 1 digit in String
//        String alphabet ="[0-9a-zA-Z]*[a-zA-Z]+[0-9a-zA-Z]*"; //must exist at least 1 alphabet in String
String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@%#&()–[{}]:;',?/*~$^+=<>]).{8,32}$"; // ?= (Positive Look ahead)

        while (true) {
            System.out.print(rb.getString("password"));
            String pass = checkInputString();
            if (pass.matches(regex)) {
                break;
            } else {
                System.err.println(rb.getString("wrong.password"));
            }
        }
    }

    public void checkCaptcha(ResourceBundle rb, String captcha) {
        System.out.println(rb.getString("captcha") + captcha);
        while (true) {
            System.out.print(rb.getString("captchaInput"));
            String result = checkInputString();
            if (captcha.contains(result)) {
                break;
            } else {
                System.err.println(rb.getString("wrong.captcha"));
            }
        }
    }
}
