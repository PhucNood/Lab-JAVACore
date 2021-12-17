/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Task;
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

    private Scanner sc = new Scanner(System.in);
    public static final int UpdateMode = 1;
    public static final int NormalMode = 0;
    public static final int notChange = -1;
    public static final String unChange = "No";

    public String checkInputString(String mess) {

        while (true) {
            System.out.print(mess);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }

    public int checkInt(String mess, int min, int max, int mode) {
        int result;
        String input;

        while (true) {
            System.out.print(mess);
            try {
                input = sc.nextLine().trim();
                if (mode == UpdateMode) {
                    if (input.equalsIgnoreCase("nope")) {
                        return notChange;
                    }

                }
                result = Integer.parseInt(input);
                if (result >= min && result <= max) {
                    return result;
                } else {
                     System.out.println("Between " + min + " and " + max + ",Please!");
                   
                }

            } catch (Exception e) {
                System.out.println("Number format please!!");
            }

        }

    }

    public String checkDate(String mess, int mode) {
        System.out.print(mess);
        SimpleDateFormat formatIn = new SimpleDateFormat("dd-MM-yyyy");
        formatIn.setLenient(false);
        String input;
        while (true) {
            input = sc.nextLine().trim();
            if (mode == UpdateMode) {
                if (input.equalsIgnoreCase("nope")) {
                    return unChange;
                }

            }
            try {

                Date date = formatIn.parse(input);
                SimpleDateFormat formatOut = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = formatOut.format(date);
                return strDate;

            } catch (ParseException e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }

        }

    }

    public double checkDouble(String mess, double min, double max, int mode) {
        double result;
        String input;

        while (true) {
            System.out.print(mess);
            input = sc.nextLine().trim();
            if (mode == UpdateMode) {
                if (input.equalsIgnoreCase("nope")) {
                    return notChange;
                }

            }
            try {
                result = Double.parseDouble(input);
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.out.println("Between " + min + " and " + max + ",Please!");

                }

            } catch (NumberFormatException e) {

                System.err.print("Must enter a real number from 8-17.5: ");
            }

        }

    }

    public double checkTime(String mess, int mode) {
        while (true) {
            double time = checkDouble(mess, 8, 17.5, mode);
            if (time % 0.5 == 0) {
                return time;
            }
            System.err.println("tithes mustm be 0 or 5");

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
