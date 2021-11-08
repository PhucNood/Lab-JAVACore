/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class J1SP0071 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Managing m = new Managing(tasks);
        while (true) {
            switch (m.welcome()) {
                case 1:m.addtask();
                    break;
                case 2:m.updateTask();
                    break;
                case 3:m.deleteTask();
                    break;
                case 4:m.getDataTasks();
                    break;
                case 5:
                    return;
            }
        }

    }
}
