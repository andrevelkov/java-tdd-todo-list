package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoListExtensionTest {

    @Test
    public void addTaskSuccessfully() {
        TodoListExtension todo = new TodoListExtension();
        Task newTask = new Task(5, "task5", false);
        todo.addTask(newTask);
        Assertions.assertEquals("task5", todo.getTaskByID(5).getName());
    }

    @Test
    public void getTaskByIdElseNotFoundResponse() {
        TodoListExtension todo = new TodoListExtension();
        Assertions.assertEquals(1, todo.getTaskByID(1).getId());
        Task task2 = todo.getTaskByID(10);
        Assertions.assertNull(task2);
    }

    @Test
    public void updateTaskByIdAndName() {
        TodoListExtension todo = new TodoListExtension();

        Assertions.assertEquals("task2", todo.getTaskByID(2).getName());
        todo.updateTask(2, "test new name");
        Assertions.assertEquals("test new name", todo.getTaskByID(2).getName());
    }

    @Test
    public void updateNonExistentTaskDoesNothing() {
        TodoListExtension todo = new TodoListExtension();
        todo.updateTask(99, "newTask");
        Assertions.assertNull(todo.getTaskByID(99));
    }

    @Test
    public void changeStatusByTaskId() {
        TodoListExtension todo = new TodoListExtension();

        Assertions.assertFalse(todo.getTaskByID(3).getStatus());
        todo.changeStatusWithId(3);
        Assertions.assertTrue(todo.getTaskByID(3).getStatus());
        todo.changeStatusWithId(3);
        Assertions.assertFalse(todo.getTaskByID(3).getStatus());
        todo.changeStatusWithId(4);
        Assertions.assertTrue(todo.getTaskByID(4).getStatus());
    }

}
