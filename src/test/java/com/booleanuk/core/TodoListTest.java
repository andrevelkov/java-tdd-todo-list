package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

class TodoListTest {
    private HashMap<String, Boolean> testmap = null;

    public void loadTasks() {
        testmap = new HashMap<>();
        testmap.put("task1", false);
        testmap.put("task2", false);
        testmap.put("task3", true);
        testmap.put("task4", false);
        testmap.put("task5", true);
    }

    @Test
    public void addTaskThatDoesNotExist() {
        loadTasks();
        TodoList list = new TodoList(testmap);

        Assertions.assertFalse(list.add("Task1"));
        Assertions.assertFalse(list.add("Task2"));
        Assertions.assertFalse(list.add("task2"));
        Assertions.assertTrue(list.add("Task10"));
        Assertions.assertFalse(list.add("Task5"));
        Assertions.assertTrue(list.add("Task20"));
        Assertions.assertFalse(list.add("  "));
    }

    @Test
    public void addTaskThatAlreadyExists() {
        loadTasks();
        TodoList list = new TodoList(testmap);
        Assertions.assertFalse(list.add("Task1"));
        Assertions.assertTrue(list.add("Task11"));
        Assertions.assertFalse(list.add("task1")); // Case-sensitive
        Assertions.assertFalse(list.add(" "));
    }

    @Test
    public void getAllTasksReturnsMapOrEmptyMapIfNoContent() {
        TodoList list = new TodoList(HashMap.newHashMap(0));
        Assertions.assertEquals(0, list.getAll().size()); // Test on Empty

        loadTasks();
        TodoList list2 = new TodoList(testmap);
        Assertions.assertEquals(5, list2.getAll().size());
        list2.add("item6");
        Assertions.assertEquals(6, list2.getAll().size());
    }

    @Test
    public void getCompletedTasks() {
        loadTasks();
        TodoList list = new TodoList(testmap);

        Assertions.assertEquals(2, list.getCompletedTasks().size());
        list.add("task25");
        Assertions.assertEquals(2, list.getCompletedTasks().size());
    }

    @Test
    public void getIncompleteTasks() {
        loadTasks();
        TodoList list = new TodoList(testmap);

        Assertions.assertEquals(3, list.getIncompleteTasks().size());
        list.add("task25");
        Assertions.assertEquals(4, list.getIncompleteTasks().size());
    }

    @Test
    public void toggleTaskStatus() {
        loadTasks();
        TodoList list = new TodoList(testmap);

        Assertions.assertTrue(list.toggleStatus("task1"));
        Assertions.assertFalse(list.toggleStatus("task500")); //task do not exist
        Assertions.assertFalse(list.toggleStatus(" "));
    }

    @Test
    public void searchForTaskWhichExists() {
        loadTasks();
        TodoList list = new TodoList(testmap);
        Assertions.assertEquals("Task found.", list.searchForTask("task2"));
        Assertions.assertEquals("Task found.", list.searchForTask("task5"));
        Assertions.assertEquals("Task found.", list.searchForTask("Task5"));
    }

    @Test
    public void searchForTaskThatDoesNotExist() {
        loadTasks();
        TodoList list = new TodoList(testmap);
        Assertions.assertEquals("Task not found.", list.searchForTask("task22"));
        Assertions.assertEquals("Task not found.", list.searchForTask("task5515"));
        Assertions.assertEquals("Task not found.", list.searchForTask("task"));
        Assertions.assertEquals("Task not found.", list.searchForTask(" "));
    }

    @Test
    public void removeTaskWhichExists() {
        loadTasks();
        TodoList list = new TodoList(testmap);
        Assertions.assertEquals(5, list.getAll().size());
        list.removeTask("task2");
        Assertions.assertEquals(4, list.getAll().size());
        list.removeTask("task1");
        Assertions.assertEquals(3, list.getAll().size());
        list.removeTask("task5");
        list.removeTask("task4");
        Assertions.assertEquals(1, list.getAll().size());
    }

    @Test
    public void removeTaskThatDoNotExist() {
        loadTasks();
        TodoList list = new TodoList(testmap);

        list.removeTask("task2");
        Assertions.assertEquals(4, list.getAll().size());
        list.removeTask("task10");
        Assertions.assertEquals(4, list.getAll().size());
        list.removeTask("");
        Assertions.assertEquals(4, list.getAll().size());
        list.removeTask(" ");
        Assertions.assertEquals(4, list.getAll().size());
    }

    @Test
    public void getTasksInAscendingOrder() {
        testmap = new HashMap<>();
        testmap.put("b", false);
        testmap.put("d", false);
        testmap.put("c", false);
        testmap.put("a", false);
        TodoList list = new TodoList(testmap);

        Assertions.assertEquals(List.of("a", "b", "c", "d"), list.getAllAscending());
    }

    @Test
    public void getTasksInDescendingOrder() {
        testmap = new HashMap<>();
        testmap.put("b", false);
        testmap.put("d", false);
        testmap.put("c", false);
        testmap.put("a", false);
        TodoList list = new TodoList(testmap);

        Assertions.assertEquals(List.of("d", "c", "b", "a"), list.getAllDescending());
    }

}
