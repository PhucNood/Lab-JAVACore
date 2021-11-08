/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h208;

/**
 *
 * @author ACER
 */
public class J1SH208 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager m = new Manager();
        
        int number = m.checkInt("Enter the number: ", 0, Integer.MAX_VALUE);
        System.out.println(m.swapDigitPairs(number));
    }
    
}
