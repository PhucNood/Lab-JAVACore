/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

/**
 *
 * @author ACER
 */
public class J1SP0011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validation val = new Validation();
        Convert convert = new Convert();
        while(true){
            int inbase =val.GetBase("Enter base input: ");
            String value =val.GetValue("Enter the value: ", inbase);
            int outbase =val.GetBase("Enter base output: ");
            
            if (inbase==10) {              
                System.out.println(convert.DectoOther(Integer.parseInt(value), outbase));
            }
            else{
                int dec =convert.OthertoDec(value, inbase);
                System.out.println(convert.DectoOther(dec, outbase));      
                 
            }
        }
      
    }
    
}
