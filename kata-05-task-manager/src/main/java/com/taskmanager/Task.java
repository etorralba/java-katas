package com.taskmanager;


import java.time.LocalDate;
import java.util.Random;


public class Task {
    private final Integer id;
    private final String name;
    private final LocalDate date;
    private final TaskPriority taskPriority;
    public enum TaskPriority {
        LOW, MEDIUM, HIGH
    }

    public Task(String name, LocalDate date, TaskPriority taskPriority) {
        Random random = new Random();
        this.id = random.nextInt(1000000000);
        this.name = name;
        this.date = date;
        this.taskPriority = taskPriority;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public Integer getId(){
        return this.id;
    }
    public TaskPriority getTaskPriority(){
        return this.taskPriority;
    }

}

