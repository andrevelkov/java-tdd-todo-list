package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class TodoList {
    HashMap<String, Boolean> todoMap = new HashMap<>();

    public TodoList(HashMap<String, Boolean> map) {
        this.todoMap = map;
    }

    public Boolean add(String name) {

        return null;
    }

    public HashMap<String, Boolean> getAll() {
        return HashMap.newHashMap(0);
    }

    public ArrayList<String> getCompletedTasks() {
        return new ArrayList<>();
    }

    public ArrayList<String> getIncompleteTasks() {
        return new ArrayList<>();
    }

    public Boolean toggleStatus(String taskName) {

        return false;
    }

    public String searchForTask(String taskName) {

        return "";
    }

    public void removeTask(String task) {

    }

    public HashMap<String, Boolean> getAllAscending() {
        return HashMap.newHashMap(0);
    }

    public HashMap<String, Boolean> getAllDescending() {
        return HashMap.newHashMap(0);
    }
}
