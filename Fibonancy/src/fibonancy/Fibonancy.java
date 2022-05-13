/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonancy;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Fibonancy {

    /**
     * @param args the command line arguments
     *
     *
     */
    static int fibonacy = 0, n1 = 0, n2 = 1;

    public static void main(String[] args) {

        System.out.print(n1 + " ," + n2); // Vi ham printdFibonacySeries in tu so thu 3
        printFibonancySeries(45 - 2); // bo 2 so dau da in roi
    }

    public static void printFibonancySeries(int index) {

        if (index > 0) {
            fibonacy = n1 + n2; // cong thuc fibo 
            System.out.print(" ," + fibonacy);
            n1 = n2;  // va so thu 2 cu se thanh so thu nhat 
            n2 = fibonacy; // Voi so fibo tiep theo thi so fibo cu se la so thu 2

            printFibonancySeries(index - 1); // recall de de quy
        }

    }
}

// f4 = f3 + f2
// f3 = f2 + f1 
// f2 =f1 + f0

