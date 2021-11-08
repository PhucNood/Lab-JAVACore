/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0052;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class J1SP0052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<EastAsianCountry> list = new ArrayList<>();
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries(list);
        //loop until user want to exist

        while (true) {
            manager.showMenu();
            int choice = manager.getInputChoice();
            switch (choice) {
                case 1:
                    manager.inputCountry();
                    break;
                case 2:
                    manager.Display();
                    break;
                case 3:
                    manager.Search();
                    break;
                case 4:
                    manager.Sort();
                    break;
                case 5:
                    return;

            }
        }

    }

}
