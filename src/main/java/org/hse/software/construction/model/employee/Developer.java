package org.hse.software.construction.model.employee;

import org.hse.software.construction.model.task.Task;
import org.hse.software.construction.model.task.TaskState;

public class Developer extends Employee {

    private Task currentTask;
    private boolean isBusy;

    public Developer(String name) {
        super(name, "Developer");
        this.currentTask = null;
    }

    public void assignTask(Task task) {

        if (!isBusy() && task != null && currentTask == null) {
            currentTask = task;
            currentTask.addObserver(this);
            currentTask.setState(TaskState.IN_PROGRESS);
            setBusy(true);
            System.out.println(name + ": Task " + task.getTitle() + " assigned.");
        } else {
            System.out.println(name + ": Cannot take on the task.");
        }
    }


    @Override
    public void update(Task task) {

        if (task == currentTask) {
            if (task.getState() == TaskState.COMPLETED) {
                System.out.println(name + ": Task " + task.getTitle() + " is completed.");
                currentTask = null;
                setBusy(false);
                task.removeObserver(this);
            } else if (task.getState() == TaskState.OUT_OF_DEADLINE) {
                System.out.println(name + ": Task " + task.getTitle() + " is out of deadline.");
                currentTask = null;
                setBusy(false);
                task.removeObserver(this);
            }
        }
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }


}

