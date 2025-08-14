package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TodoListExtension {
    ArrayList<Task> taskList = new ArrayList<>();

    public TodoListExtension() {
        taskList.add(new Task(1, "task1", false));
        taskList.add(new Task(2, "task2", false));
        taskList.add(new Task(3, "task3", false));
        taskList.add(new Task(4, "task4", false));
    }

    public void addTask(Task newTask) {
        taskList.add(newTask);
    }

    public Task getTaskByID(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void updateTask(int id, String newName) {
        for (Task task : taskList)
            if (task.getId() == id)
                task.setName(newName);
    }

    public void changeStatusWithId(int id) {
        taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst().map(task -> {task.toggleStatus();
                    return null;
                });
    }

    public Date getTaskCreationTime(String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                return task.getCreationTime();
            }
        }
        return null;
    }
}
