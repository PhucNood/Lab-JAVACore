/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author ACER
 */
public class J1SP0074 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        while (true) {            
            Manager.menu();
            int choice = Validation.checkInt("Enter your choice:" ,1, 4);
            
           switch(choice){
               case 1: 
                   Manager.addMatrix();
                   break;
               case 2:
                   Manager.subMatrix();
                   break;
                case 3:
                    Manager.Mutiplication();
                    break;
                case 4:
                    System.err.println("See you again!");
                    System.exit(0);
           }
            
        }
    
    }
    
}
