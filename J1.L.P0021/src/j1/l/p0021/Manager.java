/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class Manager {

    ArrayList<Student> list;
    Validation val = new Validation();

    public Manager(ArrayList<Student> list) {
        this.list = list;
    }

    public void menu() {
        System.out.println("");
        System.out.println("                                MENU                                     ");
        System.out.println("========================================================================");
        System.out.println("1.Create");
        System.out.println("2.Find and Sort");
        System.out.println("3.Update/Delete");
        System.out.println("4.Report");
        System.out.println("5.Exit");
        System.out.println("========================================================================");
        System.out.println("");
    }

    public void createStudent() {
        if (list.size() > 10) {
            String choice = val.checkFormatString("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen: ", "^[ynYn]{1}$");
            if (choice.equalsIgnoreCase("N")) {
                return;
            }
        }
        String code = val.checkCode(list);
        String name = val.checkFormatString("Enter name: ", "^[a-zA-Z\\s]+$");
        int semester = val.checkInt("Enter semester: ", 0, Integer.MAX_VALUE);
        int couseId = val.checkInt("Enter couseID(1-Java,2-.Net,3-C/C++): ", 1, 3);
        Map<Integer, String> course = new HashMap<>();
        course.put(1, "Java");
        course.put(2, ".Net");
        course.put(3, "C/C++");
        String courseName = course.get(couseId);
        list.add(new Student(code, name, semester, courseName));

    }

    public void FindnSort() {

        ArrayList<Student> findlist = new ArrayList<>();
        String name = val.checkFormatString("Enter name: ", "^[a-zA-Z\\s]+$").toUpperCase();

        for (Student student : list) {
            if (student.getStudentName().toUpperCase().contains(name)) {
                findlist.add(student);
            }
        }
        

        findlist.sort((s1, s2) -> s1.getStudentName().compareToIgnoreCase(s2.getStudentName()));
        for (Student student : findlist) {
            student.display();
        }

        if (findlist.isEmpty()) {
            System.err.println("Not found student have that name!!");
        }
    }

    public void UpDatenDelete() {
        boolean found = false;
        System.out.print("Enter your code:");
        String code = val.checkInputString();
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(code)) {
                found = true;
                student.display();
                String choice = val.checkFormatString("Do you want to update (U) or delete (D) student: ", "^[udUD]{1}$");
                if (choice.equalsIgnoreCase("u")) {
                    
                    String name = val.checkFormatString("Enter name: ", "^[a-zA-Z\\s]+$");
                    int semester = val.checkInt("Enter semester:", 0, Integer.MAX_VALUE);
                    int couseId = val.checkInt("Enter couseID(1-Java,2-.Net,3-C/C++): ", 1, 3);
                    Map<Integer, String> course = new HashMap<>();
                    course.put(1, "Java");
                    course.put(2, ".Net");
                    course.put(3, "C/C++");
                    String courseName = course.get(couseId);
                   
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(courseName);

                } else {
                    list.remove(student);
                    break;
                }
            }
        }
        if (found == false) {
            System.err.println("Student not found!!!");
        }

    }

    public void report() {
        for (Student student : list) {
            student.display();
        }
    }

}
