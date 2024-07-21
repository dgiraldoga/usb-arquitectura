package main.java;

import java.util.List;
import java.util.Scanner;

public class TasKUI {
    private TaskService taskService;

    public TasKUI(TaskService taskService) {
        this.taskService = taskService;
    }

    public void showMenu() {
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskService.addTask(description);
                    break;
                case 2:
                    List<Task> tasks = taskService.getTasks();
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + ". " + tasks.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Enter task index to complete: ");
                    int index = scanner.nextInt();
                    taskService.completeTask(index);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
