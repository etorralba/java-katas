package com.taskmanager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TaskService {
    private List<Task> taskList = new ArrayList<>();

    public void addTask(String taskName, LocalDate taskDate, Task.TaskPriority taskPriority){
        System.out.println(" ");
        System.out.println("Adding task...");
        Task task = new Task(taskName, taskDate, taskPriority);
        this.taskList.add(task);
        System.out.println("Successfully added Task: " + task.getName());
    }

    private String formatTaskList(List<Task> tasks) {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(String.format("- (%d) %s | %s | %s%n",
                    task.getId(), task.getName(), task.getTaskPriority(), task.getDate()));
        }
        return sb.toString();
    }

    public List<Task> listTasks(){
        System.out.println("This is the current list of tasks:");
        System.out.println(" ");
        System.out.println(formatTaskList(this.taskList));
        return this.taskList;
    }

    public void deleteTask(Integer taskId){
        System.out.println("Deleting task with id: " + taskId);
        if (this.taskList.isEmpty()){
            System.out.println("This task is not in found");
            return;
        }

        for (int i = 0 ; i < this.taskList.size() ; i++){
            if (Objects.equals(this.taskList.get(i).getId(), taskId)){
                this.taskList.remove(i);
            }
        }
    }

    public void sortTasks(){
        System.out.println(" ");
        System.out.println("Sorting by date...");

        this.taskList.sort(Comparator.comparing(Task::getDate));

        this.listTasks();
    }
}
