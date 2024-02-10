package org.hse.software.construction.model.report;

import org.hse.software.construction.model.project.Project;

public class ProjectReport implements Reportable {
    private Project project;
    private TaskReport taskReport;


    public ProjectReport(Project project, TaskReport taskReport) {
        this.taskReport = taskReport;
        this.project = project;
    }

    @Override
    public String getReport() {
        String report = "Project: " + project.getName() + "\n";
        for (var task : project.getTasks()) {
            report += taskReport.getReport() + "\n";

        }
        return report;}
}
