package com.taskmanager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialization
        Scanner reader = new Scanner(System.in);
        TaskService taskService = new TaskService();
        boolean isRunning = true;

        String intiMessage = """
                Welcome to the TASK MANAGER CLI
                1. Add Task
                2. List Tasks
                3. Sort Tasks by date
                4. Delete task by id
                5. Exit
                
                """;
        System.out.println(intiMessage);

        while(isRunning){
            System.out.println("Choose an option: ");
            int userInput = getIntegerInput(reader);

            switch (userInput) {
                case 1 -> addTask(reader, taskService);
                case 2 -> listTasks(taskService);
                case 3 -> sortTasks(taskService);
                case 4 -> deleteTask(reader, taskService);
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid option. Default value is LOW");
            }
        }
    }

    public static String getStringInput(Scanner reader){
        String userInput = reader.nextLine();
        return userInput.replaceAll("<[^>]*>", "");
    }

    public static int getIntegerInput(Scanner reader){
        String userInput = getStringInput(reader);
        try {
            return Integer.parseInt(userInput);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid argument please use a whole number");
        }
    }

    public static void addTask(Scanner reader, TaskService taskService){
        System.out.println("Enter task name:");
        String taskName = getStringInput(reader);

        System.out.println("Enter task year:");
        int taskYear = getIntegerInput(reader);
        System.out.println("""
                Select one of the following months:
                1. January
                2. February
                3. March
                4. Abril
                5. May
                6. June
                7. July
                8. August
                9. September
                10. October
                11. November
                12. December
                """);
        String taskMonth = getStringInput(reader);

        System.out.println("Enter task day:");
        int taskDay = getIntegerInput(reader);
        LocalDate taskDate = LocalDate.of(taskYear, Integer.parseInt(taskMonth), taskDay);

        Task.TaskPriority taskPriority = null;

        System.out.println("""
                Enter task priority
                1 = LOW
                2 = MEDIUM
                3 = HIGH
                """);
        int taskPriorityNumber = getIntegerInput(reader);
        switch (taskPriorityNumber) {
            case 1 -> taskPriority = Task.TaskPriority.LOW;
            case 2 -> taskPriority = Task.TaskPriority.MEDIUM;
            case 3 -> taskPriority = Task.TaskPriority.HIGH;
            default -> {
                System.out.println("Invalid option");
                taskPriority = Task.TaskPriority.LOW;
            }
        }

        taskService.addTask(taskName, taskDate, taskPriority);
    }

    public static void listTasks(TaskService taskService){
        taskService.listTasks();
    }
    public static void sortTasks(TaskService taskService){
        taskService.sortTasks();
    }
    public static void deleteTask(Scanner reader, TaskService taskService){
        System.out.println("Enter task id:");
        int taskId = getIntegerInput(reader);

        taskService.deleteTask(taskId);
    }
}
