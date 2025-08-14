package com.booleanuk.extension;

import java.util.ArrayList;
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

        return null;
    }

    public void updateTask(int id, String newName) {

    }

    public void changeStatusWithId(int id) {

    }

    public Task getTaskCreationTime(String taskName) {

        return null;
    }
}
