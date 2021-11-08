/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0063;

/**
 *
 * @author ACER
 */
public class Person {
    private String name;
    private  String Adress;
    private double salary;

    public Person() {
    }

    public Person(String name, String Adress, double salary) {
        this.name = name;
        this.Adress = Adress;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return Adress;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void display(){
        System.out.println("Information of Person you have entered:");
        System.out.println("Name: " +name);
        System.out.println("Address: "+Adress);
        System.out.println("Salary: "+salary);
        System.out.println("");
    }
    
}
