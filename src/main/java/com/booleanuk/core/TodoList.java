package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TodoList {
    HashMap<String, Boolean> todoMap = new HashMap<>();

    public TodoList(HashMap<String, Boolean> map) {
        this.todoMap = map;
    }

    public Boolean add(String task) {
        if (task.toLowerCase().trim().isEmpty()) {
            return false;
        }
        if (todoMap.containsKey(task.toLowerCase().trim())) {
            return false;
        }

        todoMap.put(task, false);
        return  true;
    }

    public HashMap<String, Boolean> getAll() {
        return todoMap;
    }

    public ArrayList<String> getCompletedTasks() {
        ArrayList<String> completedTasks = new ArrayList<>();

        for (Map.Entry<String, Boolean> entry : todoMap.entrySet())
            if (entry.getValue().equals(true))
                completedTasks.add(entry.getKey());

        return completedTasks;
    }

    public ArrayList<String> getIncompleteTasks() {
        ArrayList<String> incompleteTasks = new ArrayList<>();

        for (Map.Entry<String, Boolean> entry : todoMap.entrySet())
            if (entry.getValue().equals(false))
                incompleteTasks.add(entry.getKey());

        return incompleteTasks;
    }

    public Boolean toggleStatus(String taskName) {
        for (Map.Entry<String, Boolean> entry : todoMap.entrySet())
            if (entry.getKey().equals(taskName.toLowerCase().trim())) {
                boolean value = entry.getValue();
                entry.setValue(!value);
                return true;
            }
        return false;
    }

    public String searchForTask(String taskName) {
        for (Map.Entry<String, Boolean> entry : todoMap.entrySet())
            if (entry.getKey().equals(taskName.toLowerCase().trim()))
                return "Task found.";
        return "Task not found.";
    }

    public void removeTask(String task) {
        for (Map.Entry<String, Boolean> entry : todoMap.entrySet())
            if (entry.getKey().equals(task.toLowerCase().trim())) {
                todoMap.remove(entry.getKey());
                return;
            }
    }

    // Can use TreeMap as return ??
    public ArrayList<String> getAllAscending() {
        ArrayList<String> keyList = new ArrayList<>(todoMap.keySet());
        keyList.sort(null);

        return keyList;
    }

    public ArrayList<String> getAllDescending() {
        ArrayList<String> keyList = new ArrayList<>(todoMap.keySet());
        keyList.sort(null);
        Collections.reverse(keyList);

        return keyList;
    }
}
