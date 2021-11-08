/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;


import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class J1SP0101 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Managing m = new Managing(list);
        Validation val = new Validation();

        while (true) {
            m.menu();
            int option = val.checkInt("Enter your choice: ", 1, 7);
            switch (option) {
                case 1:
                    m.addEmployee();
                    break;
                case 2:m.updateById();
                    break;
                case 3:m.DeleteById();
                    break;
                case 4:m.Search();
                    break;
                case 5:m.Sort();
                    break;
                case 6:return;                    
                case 7:m.display();
                    break;
            }

        }
    }

}
