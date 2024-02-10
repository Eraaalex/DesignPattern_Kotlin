package org.hse.software.construction.model.employee;

import org.hse.software.construction.TaskObserver;
import org.hse.software.construction.model.task.Task;
import org.hse.software.construction.model.task.TaskState;

import java.util.List;

public class Employee implements TaskObserver {
    protected String name;
    protected String role;
    private List<Task> tasks;

    private boolean isBusy = false;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.addObserver(this);
    }
    // Method to update task status
    @Override
    public void update(Task task) {
        if (task.getState() == TaskState.COMPLETED) {
            System.out.println(name + ": Task " + task.getTitle() + " is completed.");
            tasks.remove(task);
            task.removeObserver(this);
        } else if (task.getState() == TaskState.OUT_OF_DEADLINE) {
            System.out.println(name + ": Task " + task.getTitle() + " is out of deadline.");
            tasks.remove(task);
            task.removeObserver(this);
        }
    }
}
