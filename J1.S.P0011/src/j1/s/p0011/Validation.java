/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {

    public Scanner sc = new Scanner(System.in);

    public int GetBase(String mess) {
        int base;
        while (true) {
            System.out.print(mess);
            try {
                base = Integer.parseInt(sc.nextLine().trim());
                if (base == 2 || base == 10 || base == 16) {
                    break;
                } else {
                    System.err.println("Base 2|10|16 Please!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be number!,or not empty");
            }
        }
        return base;
    }

    public String GetValue(String mess, int base) {
        while (true) {
            System.out.print(mess);

            String value = sc.nextLine().trim().toUpperCase();
           

          String regex="";
          if(base==2) regex ="[01]+";
          if(base==10) regex ="[0-9]+";
          if(base==16) regex ="[0-9a-fA-F]+";

            if (value.matches(regex)) {
                return value;
            } else {
                System.err.println("must string base " + base + " and not empty!");
            }

//                switch (base) {
//                    case 2:
//                        if (value.matches("[01]+")) {
//                            return value;
//                        } else System.err.println("must string 1-0 and not empty!");;
//                        break;
//                    case 10:
//                        if (value.matches("[0-9]+")) {
//                            return value;
//                        }else  System.err.println("must string 0-9 and not empty!");;
//                        break;
//                    case 16:
//                        if (value.matches("[0-9a-fA-F]+")) {
//                            return value;
//                        }else System.err.println("must string 0-9A-F and not empty!");;
//                        break;
//                        
//                }
        }
    }

}
