/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0102;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class J1SP0102 {

    static Scanner sc = new Scanner(System.in);

    static public String checkDate(String mes) {
        System.out.print(mes);
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
        sdformat.setLenient(false);
        while (true) {
            try {
                Date date = sdformat.parse(sc.nextLine());
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                System.out.println("Your day is" + " " + sdf.format(date));
            } catch (ParseException e) {
                System.out.println("Invalid date input, date of birth must be dd/MM/yyyy: ");
            }
        }
    }

    public static void main(String[] args) {
        String date;
        date = checkDate("Please enter date with format [dd/MM/yyyy]: ");
    }
}
