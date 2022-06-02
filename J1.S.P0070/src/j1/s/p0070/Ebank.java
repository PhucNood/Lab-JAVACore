/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0070;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author ACER
 */
public class Ebank {
     Validation val = new Validation();

    public Ebank() {
         while(true){
            int choice = menu();
                    switch (choice) {
            case 1: {
               Locale vi_Locale = new Locale("viet", "VN"); // create you defination locate by your property file
                ResourceBundle vi_bundle = ResourceBundle.getBundle("j1.s.p0070/language", vi_Locale);
                login(vi_bundle);
                break;
            }
            case 2: {
              Locale en_Locale = new Locale("eng", "US");
                ResourceBundle en_bundle = ResourceBundle.getBundle("j1.s.p0070/language", en_Locale);
                login(en_bundle);
                break;
            }
            case 3:return;
        }
                    
        }
    }
     
     
     
    private int menu() {
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice = val.checkInt("Enter your choice: ", 1, 3);
        return choice;
    }

    private String CreateCaptcha() {
        String root = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(root.length());
            captcha += root.charAt(index);
        }
        return captcha;
    }

    private void login(ResourceBundle rb) {
        val.checkAccNumber(rb);
        val.checkPass(rb);
        val.checkCaptcha(rb, CreateCaptcha());
        System.out.println(rb.getString("login.success"));
        System.out.println("");
    }
}
