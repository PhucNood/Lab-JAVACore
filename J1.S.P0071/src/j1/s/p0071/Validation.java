/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
    private  Scanner sc = new Scanner(System.in);

    public String checkInputString(String mess) {
        System.out.print(mess);
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
                 if(sc.next().trim().equalsIgnoreCase("nope")){
                    result=-1;
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a number: ");
            }
        }
        return result;
    }

      public String checkDate(String mess) {
        System.out.print(mess);
        SimpleDateFormat formatIn = new SimpleDateFormat("MMM-dd-yyyy");
        formatIn.setLenient(false);
        while(true) {          
            try {
               
                Date date = formatIn.parse(sc.nextLine());   
                SimpleDateFormat formatOut = new SimpleDateFormat("dd-MMM-yyyy");
                String strDate = formatOut.format(date);
                return strDate;
            } catch (ParseException e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
        }
    }
    
    

    public double checkDouble(String mess, double min, double max) {
        double result;
        System.out.print(mess);
        while (true) {
            try {
                
                result = Double.parseDouble(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.println("Between " + min + " and " + max + ".");
                    System.out.print("Try again: ");
                }
                if(sc.next().trim().equalsIgnoreCase("nope")){
                    result=-1;
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a real number from 8-17.5: ");
            }
        }
        return result;
    }

    public double checkTime(String mess) {
        while (true) {
            double time = checkDouble(mess, 8, 17.5);
            if (time % 0.5 == 0) {
                return time;
            } else {
                System.err.println("tithes mustm be 0 or 5");
            }
        }
    }


    public Task isIdExists(ArrayList<Task> tasks, int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    } 
}
