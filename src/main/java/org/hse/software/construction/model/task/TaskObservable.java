package org.hse.software.construction.model.task;

import org.hse.software.construction.TaskObserver;

public interface TaskObservable {

    void addObserver(TaskObserver observer);
    void removeObserver(TaskObserver observer);
    void notifyObservers();
}
