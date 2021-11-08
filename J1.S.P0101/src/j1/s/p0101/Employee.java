/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0101;

/**
 *
 * @author ACER
 */
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String DOB;
    private String Sex;
    private double salary;
    private String egency;

    public Employee() {
    }
      
    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String DOB, String Sex, double salary, String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.salary = salary;
        this.egency = egency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getSex() {
        return Sex;
    }

    public double getSalary() {
        return salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }
    
  public  void show(){
      System.out.format("%-5s%-5s%-17s%-15s%-15s%-20s%-15s%-15s%-17.3f%-17s\n",id,firstName,lastName,phone,email,address,DOB,Sex,salary,egency);
      System.out.println("-----------------------------------------------------------------");
  }
    
}
