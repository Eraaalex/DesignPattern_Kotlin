package org.hse.software.construction.service.report;

import org.hse.software.construction.model.report.ProjectReport;

public class ProjectReportCommand implements Command {
    private ProjectReport projectReport;

    public ProjectReportCommand(ProjectReport projectReport) {
        this.projectReport = projectReport;
    }

    @Override
    public String execute() {
        return projectReport.getReport();
    }
}