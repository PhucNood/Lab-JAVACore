/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;

import java.util.ArrayList;
import java.util.Comparator;


/**
 *
 * @author ACER
 */
public class Managing {

    public Validation val = new Validation();

    private ArrayList<Employee> listE;

    public Managing(ArrayList<Employee> listE) {
        this.listE = listE;
    }

    public void menu() {
        System.out.println("                                MENU                                     ");
        System.out.println("========================================================================");
        System.out.println("1.Add employees ");
        System.out.println("2.Update employees ");
        System.out.println("3.Remove employees");
        System.out.println("4.Search employees by Name");
        System.out.println("5.Sort employees by salary ");
        System.out.println("6.Exit ");
        System.out.println("========================================================================");

    }

    public void addEmployee() {
        System.out.print("Enter id of employee: ");
        String id = val.checkInputString();
        while(val.CheckID(listE, id)!=null){ //loop when id was exist
            System.out.print("Enter id of employee: ");
            System.err.println("ID exsit!");
             id = val.checkInputString();
        }
        String fistName = val.checkFormatString("Enter fistname:", "^[A-Za-z]+$");// format name must be // other will same
        String lastname = val.checkFormatString("Enter lastname:", "^[A-Za-z\\s]+$");
        String phone = val.checkFormatString("Enter phone number:", "^[0-9]{10}$");
        String email = val.checkFormatString("Enter email :", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        String address = val.checkFormatString("Enter address:", "^[\\w\\s]+$");
        String DOB = val.checkDate("Enter Dob: ");
        String sex = val.checkFormatString("Enter sex(M/F):", "^[fmFM]{1}$").toUpperCase();
        double salary = val.checkDouble("Enter salry: ", 1, Double.POSITIVE_INFINITY);
        String egency = val.checkFormatString("Enter egency:", "^[A-Za-z\\s]+$");
        listE.add(new Employee(id, fistName, lastname, phone, email, address, DOB, sex, salary, egency));
        System.out.println("Add success");

    }

    public void updateById() {
        System.out.print("Enter id of employee: ");
        String id = val.checkInputString();
        if(val.CheckID(listE, id)==null){ //object not in list => id not existed
             System.err.println("ID not in list"); // alert
             return;
        }else{ // id existed => object in list
        String fistName = val.checkFormatString("Enter fistname:", "^[A-Za-z]+$"); 
        String lastname = val.checkFormatString("Enter lastname:", "^[A-Za-z\\s]+$");
        String phone = val.checkFormatString("Enter phone number:", "^[0-9]{10}$");
        String email = val.checkFormatString("Enter email :", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        String address = val.checkFormatString("Enter address:", "^[\\w\\s]+$");
        String DOB = val.checkDate("Enter Dob: ");
        String sex = val.checkFormatString("Enter sex(M/F):", "^[fmFM]{1}$").toUpperCase();
        double salary = val.checkDouble("Enter salry: ", 1, Double.POSITIVE_INFINITY);
        String egency = val.checkFormatString("Enter egency:", "^[A-Za-z\\s]+$");
            
         Employee emp  =  val.CheckID(listE, id);
         
         emp.setFirstName(fistName);
         emp.setLastName(lastname);
         emp.setPhone(phone);
         emp.setEmail(email);
         emp.setAddress(address);
         emp.setDOB(DOB);
         emp.setSex(sex);
         emp.setSalary(salary);
         emp.setEgency(egency);
         
        }
        
   
    }

    public void DeleteById() {
        System.out.print("Enter id:");
        String id = val.checkInputString();
        for (Employee employee : listE) {
            if (employee.getId().equalsIgnoreCase(id)) {
                listE.remove(employee);
                
                break;
            }
        }
    }

    public void Search() {
        String name = val.checkFormatString("Enter any-part of name:", "^[A-Za-z]+$").toUpperCase();
        for (Employee employee : listE) {
            String fullname = employee.getFirstName() + " " + employee.getLastName();
            if (fullname.toUpperCase().contains(name)) {
                employee.show();

            }
        }
    }

    public void display() { 
        if(listE.isEmpty()) System.err.println("List is empty");;
        for (Employee employee : listE) {
            employee.show();
        }
    }

    public void Sort() { 
        if(listE.isEmpty()) System.err.println("List is empty");
        listE.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())); // using sort method and lamda experesion for comparator
        for (Employee employee : listE) {
            employee.show();
        }
    }

}
