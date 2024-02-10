package org.hse.software.construction;

import org.hse.software.construction.model.task.Task;

public interface TaskObserver {
        void update(Task task);

}
