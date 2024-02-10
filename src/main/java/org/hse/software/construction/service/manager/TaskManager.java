package org.hse.software.construction.service.manager;

import org.hse.software.construction.model.employee.Employee;
import org.hse.software.construction.model.task.Task;
import org.hse.software.construction.model.task.TaskState;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;

    private TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void assignTask(Task task, Employee employee) {

        task.setAssignedEmployee(employee);
    }

    public void markTaskAsComplete(Task task) {
        task.setState(TaskState.COMPLETED);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void checkAllTasks() {
        for (Task task : tasks) {
            task.checkDeadline();
        }
    }
}
