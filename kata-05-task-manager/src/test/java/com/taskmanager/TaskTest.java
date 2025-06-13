package com.taskmanager;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testAddTaskIncreaseList(){
        TaskService service = new TaskService();
        service.addTask("Buy something", LocalDate.now(), Task.TaskPriority.HIGH);

        assertEquals(1, service.listTasks().size());
    }
    @Test
    void testTaskIsCorrectlyCreated(){
        TaskService service = new TaskService();
        LocalDate date = LocalDate.of(2025, 5, 30);
        String taskMessage = "Test task";
        service.addTask(taskMessage, date, Task.TaskPriority.LOW);

        Task task = service.listTasks().get(0);
        assertEquals(taskMessage, task.getName());
        assertEquals(date, task.getDate());
        assertEquals(Task.TaskPriority.LOW, task.getTaskPriority());
    };

    @Test
    void testDeleteTask(){
        TaskService service = new TaskService();
        service.addTask("Task 1", LocalDate.now(), Task.TaskPriority.LOW);
        int taskId = service.listTasks().get(0).getId();

        service.deleteTask(taskId);
        assertEquals(0, service.listTasks().size());
    };

    @Test
    void testSortTasks(){
        TaskService service = new TaskService();
        service.addTask("Second", LocalDate.of(2025, 12, 1), Task.TaskPriority.HIGH);
        service.addTask("First", LocalDate.of(2025, 1, 1), Task.TaskPriority.LOW);

        service.sortTasks();
        List<Task> sorted = service.listTasks();

        assertEquals("First", sorted.get(0).getName());

    };
}
