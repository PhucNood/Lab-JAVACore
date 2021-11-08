/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ManageEastAsiaCountries {

    private final Scanner sc = new Scanner(System.in);

    ArrayList<EastAsianCountry> list;

    public ManageEastAsiaCountries(ArrayList<EastAsianCountry> list) {
        this.list = list;
    }

    public void showMenu() {
        System.out.println("                                MENU                                     ");
        System.out.println("========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending");
        System.out.println("5. Exit");
        System.out.println("========================================================================");

    }

    // get value of your choice exactly format  
    public int getInputChoice() {
        System.out.print("Enter your choice: ");
        //  run the loop untill user enter right input number of choice
        while (true) {
            // check exception input for number
            try {
                int number = Integer.parseInt(sc.nextLine());
                // check if user enter number outer range
                if ((number <= 5) && (number >= 1)) {
                    return number;
                } else {
                    System.err.println("out of range 1 to 5");
                    System.out.print("Please enter again: ");
                }
            } catch (NumberFormatException e) { // check if number is not format
                System.err.println("Must be a Ingeger number");
                System.out.print("Please enter again: ");
            }
        }
    }

    // get value of Float number exactly format  
    public float getInputFloat(float min, float max, String mess) {
        System.out.print(mess);
        float result;
        while (true) {
            // check exception input for number
            try {
                result = Float.parseFloat(sc.nextLine().trim());
                if (result >= 0 && result <= Float.MAX_VALUE) {
                    break;
                } else {
                    System.err.print("please enter over 0 ");
                }
            } catch (NumberFormatException e) { // check if number is not format
                System.err.println("Must be a Positive number");
                System.out.print("Enter agian: ");
            }

        }
        return result;
    }

    //get string from input of user
    public String getInputString(String mess) {
        System.out.print(mess);
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check country exist by code
    public EastAsianCountry CheckCode(String code) {
        for (EastAsianCountry eastAsianCountry : list) {
            if (code.equalsIgnoreCase(eastAsianCountry.getCountryCode())) {
                return eastAsianCountry;
            }
        }
        return null;
    }

    public void inputCountry() {
        String code = getInputString("Country code: ");
        while (CheckCode(code) != null) {
            System.err.println("Country exist!");
            code = getInputString("Enter country code again: ");
        }
        String name = getInputString("Country name: ");
        float totalArea = getInputFloat(0, Float.POSITIVE_INFINITY, "Total Area: ");
        String terrain = getInputString("Terrain: ");
        list.add(new EastAsianCountry(code, name, totalArea, terrain));
        System.out.println("Add success");
    }

    public void Display() {
        if (list.isEmpty()) {
            System.err.println("List still empty!!!");
            System.out.println("");
        } else {
            System.out.printf("%-10s%-25s%-20s%-25s\n", "Code", "Name", "Total Area", "Terrain");
            for (EastAsianCountry eastAsianCountry : list) {
                eastAsianCountry.display();
            }
            System.out.println("");
        }

    }

    public void Search() {

        String name = getInputString("Enter country name: ");
        boolean inlist = false;
        for (EastAsianCountry eastAsianCountry : list) {
            if (name.equalsIgnoreCase(eastAsianCountry.getCountryName())) {
                System.out.printf("%-10s%-25s%-20s%-25s\n", "Code", "Name", "Total Area", "Terrain");
                eastAsianCountry.display();
                inlist = true;
                break;
            }

        }
        if (inlist == false) {
            System.err.println("Country not in list");
        }
    }

    public void Sort() {
        if (list.isEmpty()) {
            System.err.println("List still empty!!!");
            System.out.println("");
        } else {
            list.sort((c1,c2)->c1.countryName.compareToIgnoreCase(c2.countryName));
            System.out.printf("%-10s%-25s%-20s%-25s\n", "Code", "Name", "Total Area", "Terrain");
            for (EastAsianCountry eastAsianCountry : list) {
                eastAsianCountry.display();
            }
            System.out.println("");
        }
      
    }

}
