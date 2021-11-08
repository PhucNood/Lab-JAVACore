/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0070;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ACER
 */
public class J1SP0070 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               Ebank e = new Ebank();
        
        while(true){
            int choice = e.menu();
                    switch (choice) {
            case 1: {
               Locale vi_Locale = new Locale("vietnam", "VN");
                ResourceBundle vi_bundle = ResourceBundle.getBundle("j1.s.p0070/language", vi_Locale);
                e.login(vi_bundle);
                break;
            }
            case 2: {
              Locale en_Locale = new Locale("english", "US");
                ResourceBundle en_bundle = ResourceBundle.getBundle("j1.s.p0070/language", en_Locale);
                e.login(en_bundle);
                break;
            }
            case 3:return;
        }
                    
        }

    }
    
}
