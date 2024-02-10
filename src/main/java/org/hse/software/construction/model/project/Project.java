package org.hse.software.construction.model.project;

import org.hse.software.construction.model.task.Task;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Task> tasks;

    public Project() {
        this.tasks = new ArrayList<>();
    }

    public Project(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class ProjectBuilder {
        private Project project;

        public ProjectBuilder() {
            project = new Project();
        }

        public ProjectBuilder setName(String name) {
            project.setName(name);
            return this;
        }


        public ProjectBuilder addTask(Task task) {
            project.addTask(task);
            return this;
        }

        public Project build() {
            return project;
        }
    }

    private void addTask(Task task) {
        tasks.add(task);
    }
}