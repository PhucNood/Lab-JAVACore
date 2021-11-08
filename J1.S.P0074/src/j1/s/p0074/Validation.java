/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    public static int checkInt(String mess, int min, int max) {
        int result;
        System.out.print(mess);
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.out.print("invalid,please re-enter: ");
                          
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a number: ");
            }
        }
        return result;
    }
}
