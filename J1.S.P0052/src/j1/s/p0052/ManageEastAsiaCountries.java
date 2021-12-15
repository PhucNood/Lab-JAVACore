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
    private ArrayList<EastAsianCountry> list;

    public ManageEastAsiaCountries() {
        list = new ArrayList<>();
        program();

    }

    private void program() {
        while (true) {
            int choice = showMenuAndChoice(); // show menu and choice
            switch (choice) {
                case 1:
                    addContry();
                    break;
                case 2:
                    displayList();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:SortAcendingbyName();
                    break;
                case 5:
                    return;
            }
        }
    }

    private int showMenuAndChoice() {  // show menu and return choice
        System.out.println("                            MENU\n"
                + // show menu
                "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================\n"
        );
        int choice = checkInt("Enter your choice: ", 1, 5);
        return choice;
    }

    private int checkInt(String mess, int min, int max) { //check data type int in this case is choice
        int number;
        while (true) {// loop until  true/return
            System.out.print(mess); // show the message/ title you want
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) { // if in valid rage 
                    return number;
                } else {  // out of valid rage / in-valid rage
                    System.err.println("Number must in rage " + min + " to " + max); // show warning error
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! "); // show warning exception
            }
        }

    }

    private float checkFloat(String mess, float min, float max) { //check data type float in this case is area data
        float number;
        while (true) {// loop until  true/return
            System.out.println(mess); // show the message/ title you want
            try {
                number = Float.parseFloat(sc.nextLine().trim());
                if (number > min && number <= max) { // if in valid rage 
                    return number;
                } else {  // out of valid rage / in-valid rage
                    System.err.println("Number must in rage " + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! ");// show warning exception
            }
        }

    }

    private String checkString(String mess) { //check data type String
        String s;
        //  System.out.println(mess); 
        while (true) { // loop until  true/return
            // show the message/ title you want
            System.out.println(mess);
            s = sc.nextLine().trim();
            if (s.isEmpty()) {  // conditon check String empty or not
                System.out.println("Your input is Empty! "); // show warning error

            } else {
                return s;
            }
        }

    }

    private EastAsianCountry checkContryExist(String code) { // code is super-key of EAC
        for (EastAsianCountry eac : list) {
            if (eac.getCountryCode().equalsIgnoreCase(code)) { // if key is exist
                return eac; // exist that country
            }

        }
        return null;
    }

    private void addContry() {
        String code = checkString("Enter code of country: "); // check string input
        while (checkContryExist(code) != null) { // loop while contry existed
            System.err.println("Contry existed!");
            code = checkString("Enter code of country: "); // re-input code
        }
        String name = checkString("Enter name of country: ");
        float area = checkFloat("Enter total Area: ", 0, Float.POSITIVE_INFINITY); // check float input rage greater 0 to positive infinive
        String terain = checkString("Enter terrain of country: "); // check string input
        list.add(new EastAsianCountry(code, name, area, terain)); // add new country you input to list
    }

    private void displayList() { // display list
        if (list.isEmpty()) {
            System.err.println("List is still empty!"); //if list is empty alert
            System.out.println("");
        } else {
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                    "Terrain"); // print title
            for (EastAsianCountry eac : list) { // loop to show each eac
                eac.display(); // display infor of each
            }
            System.out.println("");
        }

    }

    private void searchByName() {
        if (list.isEmpty()) {
            System.out.println("");
            System.err.println("List is still empty!"); //if list is empty alert

        } else {
            String searchName = checkString("Enter the name you want to search for: "); // input name coutry you want to search
            boolean isFound = false;
            for (EastAsianCountry eac : list) {
                if (searchName.equalsIgnoreCase(eac.getCountryName())) {
                    isFound = true; // founded
                    System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                            "Terrain"); // print title
                    eac.display();
                    break; // out of loop
                } else {
                    isFound = false; // not founded
                }

            }
            if (isFound == false) {
                System.err.println("Not found this country!");
                System.out.println("");
            }
        }
    }
    
    
    private void SortAcendingbyName(){ // sort list acending by name
        ArrayList<EastAsianCountry> sortList = new ArrayList<>(list); // create new list same elemets  to not efected to origin list
        if (sortList.isEmpty()) {
            System.out.println("");
            System.err.println("List is still empty!"); //if list is empty alert

        } else {
            
            // sort list
            sortList.sort((c1,c2)->c1.getCountryName().compareToIgnoreCase(c2.getCountryName())); /*use sort build-in funtion of Collect this have 
                                                                                                       parameter is a funtional interface Comparator so can use 
                                                                                                     lamda expression to overide method compare of this interface
                                                                                                        */ 
            // display sort list
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                            "Terrain"); // print titled
            for (EastAsianCountry eac: sortList) {
                eac.display();
            }
            System.out.println("");
        }
    }

}
