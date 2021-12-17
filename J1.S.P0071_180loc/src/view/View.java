/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Task;

/**
 *
 * @author ACER
 */
public class View {

    private ArrayList<Task> tasks;
    
    public View( ArrayList<Task> tasks) {
        this.tasks =tasks;
        getDataTasks();
    }
    
    
    
    private void getDataTasks() {
        System.out.println("====================Task=========================");
        System.out.format("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        String typeName;
        double time;
        Map<Integer, String> name = new HashMap<>();
        name.put(1, "Code");
        name.put(2, "Test");
        name.put(3, "Design");
        name.put(4, "Review");

        for (Task task : tasks) {
            typeName = name.get(task.getTaskTypeId());
            time = task.getPlanTo() - task.getPlanFrom();
            System.out.format("%-5s%-15s%-15s%-15s%-10.1f%-10s%-10s\n",
                    task.getId(), task.getRequirementName(), typeName, task.getDate(),
                    time, task.getAssignee(), task.getReviewer());
        }
    }
}
