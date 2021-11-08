/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0063;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class J1SP0063 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=====Management Person program=====");
        Validation val = new Validation();
        ArrayList<Person> listPerson = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String name = val.checkFormatString("Please input name: ", "[a-zA-Z]+");
            String address = val.checkFormatString("Please input address:", "[\\w ]+");
            double salary = val.checkDouble("Please enter salary:", 0, Double.POSITIVE_INFINITY);
            listPerson.add(new Person(name, address, salary));
        }
        System.out.println("");
        listPerson.sort((p1,p2)->Double.compare(p1.getSalary(), p2.getSalary()));
        for (Person person : listPerson) {
            person.display();
        }
        
    }
    
}
