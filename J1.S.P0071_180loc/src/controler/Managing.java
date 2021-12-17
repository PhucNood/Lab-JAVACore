/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Task;
import java.util.ArrayList;
import view.View;

/**
 *
 * @author ACER
 */
public class Managing {

    private final ArrayList<Task> tasks;
    private final Validation val;

    public Managing() {
        tasks = new ArrayList<>();
        val = new Validation();

        program();
    }

    private void program() {
        while (true) {
            int choice = menuAndchoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    new View(tasks);
                    break;
                case 5:
                    return;

            }
        }
    }

    private int menuAndchoice() {
        System.out.println("===================Task Program==================");
        System.out.println("1. Add task\n"
                + "2. Update\n"
                + "3. Delete task\n"
                + "4. Display task\n"
                + "5. Exit"
        );
        int option = val.checkInt("Enter your choice: ", 1, 4, Validation.NormalMode);
        return option;
    }

    private void addTask() {
        System.out.println("====================Add Task=========================");
        int id;
        if (tasks.isEmpty()) {
            id = 1;
        } else {
            id = tasks.get(tasks.size() - 1).getId() + 1;
        }
        String name = val.checkInputString("Requement name:");
        int tasktype = val.checkInt("Task type:", 1, 4, Validation.NormalMode);
        String date = val.checkDate("Date: ", Validation.NormalMode);
        double from;
        double to;
        from = val.checkTime("From: ", Validation.NormalMode);
        while (from == 17.5) {
            System.out.println("Can't start at last hours");
            from = val.checkTime("From: ", Validation.NormalMode);
        }
        do {
            to = val.checkTime("To: ", Validation.NormalMode);
            if (to <= from) {
                System.out.println("From can't after to");
                System.out.println("Plan from now is " + from);
            }

        } while (to <= from);
        String assignee = val.checkInputString("Assignee:");
        String reviewer = val.checkInputString("Reviewer:");
        tasks.add(new Task(id, tasktype, name, date, from, to, assignee, reviewer));
    }

    private void updateTask() {
        System.out.println("====================Update Task=========================");
        int id = val.checkInt("Requirement ID: ", 1, Integer.MAX_VALUE, Validation.NormalMode);
        if (val.isIdExists(tasks, id) == null) {
            System.err.println("ID Not found! ");

        } else {
            Task task = val.isIdExists(tasks, id);
            String name = val.checkInputString("Requement name:");
            int tasktype = val.checkInt("Task type:", 1, 4, Validation.UpdateMode);
            String date = val.checkDate("Date: ", Validation.UpdateMode);
            double from;
            double to;
            from = val.checkTime("From: ", Validation.UpdateMode);
            if (from == Validation.notChange) {
                from = task.getPlanFrom();
            }

            while (from == 17.5) {
                System.out.println("Can't start at last hours");
                from = val.checkTime("From", Validation.UpdateMode);
            }
            do {
                to = val.checkTime("To: ", Validation.UpdateMode);
                if (to == Validation.notChange) {
                    to = task.getPlanTo();
                }
                if (to <= from) {
                    System.out.println("From can't after to");
                    System.out.println("Plan from now is " + from);
                }

            } while (to <= from);
            String assignee = val.checkInputString("Assignee:");
            String reviewer = val.checkInputString("Reviewer:");

            if (!name.equalsIgnoreCase("nope")) {
                task.setRequirementName(reviewer);
            }
            if (tasktype != Validation.notChange) {
                task.setTaskTypeId(tasktype);
            }
            if (!date.equalsIgnoreCase(Validation.unChange)) {
                task.setDate(date);
            }
            if (from != Validation.notChange) {
                task.setPlanFrom(from);
            }
            if (to != Validation.notChange) {
                task.setPlanTo(to);
            }
            if (!assignee.equalsIgnoreCase("nope")) {
                task.setAssignee(assignee);
            }
            if (!reviewer.equalsIgnoreCase("nope")) {
                task.setReviewer(reviewer);
            }

        }

    }

    private void deleteTask() {
        int id = val.checkInt("Requirement ID: ", 1, Integer.MAX_VALUE, Validation.NormalMode);
        if (val.isIdExists(tasks, id) == null) {
            System.err.println("ID Not found! ");
        } else {
            Task task = val.isIdExists(tasks, id);
            tasks.remove(task);
            System.out.println("Remove success");
        }

    }

}
