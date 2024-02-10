package org.hse.software.construction.model.task;

import org.hse.software.construction.TaskObserver;
import org.hse.software.construction.model.employee.Employee;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class Task implements TaskObservable {
    private String title;
    private String description;
    private Employee assignedEmployee;
    private TaskState state;
    private LocalDate deadline;
    private List<TaskObserver> observers;


    public Task(String title){
        this.title = title;
        this.state = TaskState.TODO;
        this.deadline = LocalDate.of(2024,2,2);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getAssignedEmployee() {

        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        observers.add(assignedEmployee);
        this.assignedEmployee = assignedEmployee;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
        checkDeadline();
    }

    public void checkDeadline() {
        if (!LocalDate.now().isAfter(this.deadline)) {
            this.state = TaskState.OUT_OF_DEADLINE;
            notifyObservers();
        }
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    @Override
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update(this);
        }
    }
}

