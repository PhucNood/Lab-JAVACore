/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h208;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Manager {

    private Scanner sc = new Scanner(System.in);

    public int checkInt(String mess, int min, int max) {
        int result;
        System.out.print(mess);
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.print("Out of range! please enter in range "
                            + "[" + min + "," + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a number: ");
            }
        }
        return result;
    }

    public int swapDigitPairs(int n) {
        int result = 0;
        int m = 1;

        while (n > 0) {
            int d1 = n % 10; // take any digit in number
            n /= 10;

            if (n == 0) {
                result += m * d1;
                break;
            }

            int d2 = n % 10;
            result = result + m * 10 * d1 + m * d2;
            n /= 10;
            m *= 100;
        }

        return result;
    }

}
