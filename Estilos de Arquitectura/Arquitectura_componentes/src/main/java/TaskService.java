package main.java;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
     private List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
        } else {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
    }
}
