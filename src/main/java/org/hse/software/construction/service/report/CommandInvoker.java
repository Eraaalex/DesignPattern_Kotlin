package org.hse.software.construction.service.report;

import org.hse.software.construction.service.report.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandInvoker {
    private final Queue<Command> commandQueue;

    public CommandInvoker() {
        commandQueue = new LinkedList<>();
    }

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }
}