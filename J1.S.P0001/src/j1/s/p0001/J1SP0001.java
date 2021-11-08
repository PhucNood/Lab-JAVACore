/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class J1SP0001 {
   static Scanner sc = new Scanner(System.in);
   
     public static int checkInt(String mess, int min, int max) {
        int result;
        System.out.print(mess);
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.print("Out of range! please enter in range ");
                          
                }
            } catch (Exception e) {
                System.err.print("Must enter a number: ");
            }
        }
        return result;
    }
     
     static int inputSizeOfArray() {
        int n = checkInt("Enter the size of array: ", 0, Integer.MAX_VALUE);
        return n;
    }
     public static void display(int arr[]) {
        int i;
        System.out.print("[");
 
        // Duyet qua tat ca phan tu
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
 
        System.out.print("]\n");
    }
     
     private static void sortArrayByBubbleSort(int[] a) {
        System.out.print("Unsorted array: [");
        boolean swapped = false;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
         System.out.println("]");
        for (int i = 0; i < a.length; i++) {
            swapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
              System.out.print("So sanh cac phan tu: [" + a[j] + ", " + a[j + 1] + "]"+"\n");
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp; 
                     
                     System.out.println(" => trao doi [" + a[j] + ", " + a[j + 1] + "]");
                     swapped = true;
                                
                }else{
                     System.out.print(" => khong can trao doi"+"\n");
                }
                System.out.print("");
            }
             if (!swapped) {
                break;
            }
 
            System.out.print("Vong lap thu " + (i + 1)+" :");
            display(a);
        }
         //System.out.println("]");
         display1(a);
        System.out.println();
    }
     
     
    
     
   

    //display array after sort
    private static void display1(int[] a) {
        System.out.print("Sorted array: ");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
        System.out.println("");
    }

     
    public static void main(String[] args) {
        int size = inputSizeOfArray();
        int[] a=new int[size];
        Random random = new Random();
       
        
        StringBuilder s = new StringBuilder("yasuo");
        
        
        for (int i = 0; i < a.length; i++) {
           a[i]=random.nextInt((size+size)+1)-size;
           
        }       
        sortArrayByBubbleSort(a);
        //display(a);
        
    }
    
    
    
}
