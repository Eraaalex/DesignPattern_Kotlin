package org.hse.software.construction;

import org.hse.software.construction.model.employee.Employee;
import org.hse.software.construction.model.project.Project;
import org.hse.software.construction.model.report.ProjectReport;
import org.hse.software.construction.model.report.TaskReport;
import org.hse.software.construction.model.task.Task;
import org.hse.software.construction.model.task.TaskBuilder;
import org.hse.software.construction.service.manager.TaskManager;
import org.hse.software.construction.service.report.CommandInvoker;
import org.hse.software.construction.service.report.ProjectReportCommand;
import org.hse.software.construction.service.report.TaskReportCommand;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Employee developer1 = new Employee("D1", "Developer");
        Employee developer2 = new Employee("D2", "Developer");


        Task task1 = new TaskBuilder("Create smth")
                .setDescription("Create whatever you like")
                .setAssignedEmployee(developer1)
                .build();

        Task task2 = new TaskBuilder("Resolve smth")
                .setDescription("Resolve whatever you like")
                .setAssignedEmployee(developer2)
                .build();


        Project project = new Project.ProjectBuilder()
                .setName("New Successful Project")
                .addTask(task1)
                .addTask(task2)
                .build();

        TaskManager taskManager = TaskManager.getInstance();
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.assignTask(task1, developer1);
        taskManager.assignTask(task2, developer2);

        ProjectReportCommand projectReportCommand = new ProjectReportCommand(new ProjectReport(project, new TaskReport(task1)));
        TaskReportCommand taskReportCommand1 = new TaskReportCommand(new TaskReport(task1));
        TaskReportCommand taskReportCommand2 = new TaskReportCommand(new TaskReport(task2));

        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.addCommand(taskReportCommand1);
        commandInvoker.addCommand(taskReportCommand2);
        commandInvoker.addCommand(projectReportCommand);


        commandInvoker.executeCommands();
    }

}






