package org.hse.software.construction.model.task;

import org.hse.software.construction.model.employee.Employee;

public class TaskBuilder {
    private Task task;

    public TaskBuilder(String title) {
        this.task = new Task(title);
    }

    public TaskBuilder setDescription(String description) {
        this.task.setDescription(description);
        return this;
    }

    public TaskBuilder setAssignedEmployee(Employee assignedEmployee) {
        this.task.setAssignedEmployee(assignedEmployee);
        return this;
    }

    public TaskBuilder setCompleted(TaskState state) {
        this.task.setState(state);
        return this;
    }

    public Task build() {
        return this.task;
    }
}
