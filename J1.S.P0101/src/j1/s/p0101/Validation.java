/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;


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
    
      public String checkInputString() {   // function for check string empty or not
        while (true) {  // loop till corect 
            String result = sc.nextLine().trim();
            if (result.isEmpty()) { // condition for string input not empty
                System.err.println("Not empty."); // alert
                System.out.print("Try again: ");
            } else {
                return result;   
            }
        }
    }

    public int checkInt(String mess, int min, int max) { //funtion for check input is integer or not
        int result;
        System.out.print(mess);   // print the message you want
        while (true) {
            try {  // catch the exception when input not in numberformat
                result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) { // in the satisfy rage 
                    break;
                } else {
                    System.err.print("Out of range! please enter in range "  // alert when out of the rage
                            + "[" + min + "," + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a number: ");
            }
        }
        return result;
    }

      public String checkDate(String mess) {
        System.out.print(mess);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
        dateFormat.setLenient(false); // not plus the over day to other month ,ex : 33/4 -> 3/5  
        while(true) {          
            try {
                Date date = dateFormat.parse(sc.nextLine());     // input the date from keyboard           
                String strDate = dateFormat.format(date); // fomat the date form by dateformat
                return strDate;              
            } catch (ParseException e) { //catch on parse string to date fail
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
        }
    }
    
    

    public double checkDouble(String mess, double min, double max) {  // same like checkint but double
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
            } catch (NumberFormatException e) {
                System.err.print("Must enter a real number ! ");
            }
        }
        return result;
    }
    
    public String  checkFormatString(String mess,String parternFomart){ // check the string is format like you want : match with your partern (regex)
       String result;
       while(true){
           System.out.print(mess);
           result=checkInputString();
           if (result.matches(parternFomart)) { // must be match with you partern you give(regex)
               break;
           }else{
               System.err.println("Wrong format bruh!!!"); // if not then alert 
              
           }
       }
       return result;
    }
    

public Employee CheckID(ArrayList<Employee> list,String id ){ // check the ID existed or not
    for (Employee employee : list) {   // search each obj in list   
        if (employee.getId().equalsIgnoreCase(id)) {   // if the id input was exist in list 
            return employee; // return that object idex in list
        }
    }
    return null; //object not existed 
}
  
}
