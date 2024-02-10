package org.hse.software.construction.service.report;

import org.hse.software.construction.model.report.TaskReport;

public class TaskReportCommand implements Command {
    private TaskReport taskReport;

    public TaskReportCommand(TaskReport taskReport) {
        this.taskReport = taskReport;
    }

    @Override
    public String execute() {
        return taskReport.getReport();
    }
}
