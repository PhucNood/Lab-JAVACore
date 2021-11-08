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
public class Convert {

    public int OthertoDec(String Other, int base) {
        int result = 0;
        String hex = "0123456789ABCDEF";
        for (int i = 0; i < Other.length(); i++) {
            result += hex.indexOf(Other.charAt(i)) * Math.pow(base, Other.length() - 1 - i);
          
        }          
        return result;
    }

    
    
    public String DectoOther(int Dec, int base) {
        String result = "";
        String hex = "0123456789ABCDEF";
        while (Dec > 0) {
            result = hex.charAt(Dec % base) +result ; 
            Dec /= base;
        }
        return result;

      

    }
    
    
   
    
}
