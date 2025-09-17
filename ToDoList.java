import java.util.ArrayList;
import java.util.Scanner;
class Task {
    String name;
    boolean isCompleted;
    
    Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
}
public class ToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("\n========= TO-DO LIST =========");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    tasks.add(new Task(name));
                    System.out.println("✅ Task added successfully!");
                    break;

                case 2: // Show
                    if (tasks.isEmpty()) {
                        System.out.println("⚠️ No tasks found.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.isCompleted ? "[✔]" : "[ ]";
                            System.out.println((i + 1) + ". " + status + " " + t.name);
                        }
                    }
                    break;

                case 3: // Mark as completed
                    if (tasks.isEmpty()) {
                        System.out.println("⚠️ No tasks to mark.");
                        break;
                    }
                    System.out.print("Enter task number to mark completed: ");
                    int completeIndex = sc.nextInt();
                    if (completeIndex > 0 && completeIndex <= tasks.size()) {
                        tasks.get(completeIndex - 1).isCompleted = true;
                        System.out.println("✅ Task marked as completed!");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                    break;

                case 4: // Delete
                    if (tasks.isEmpty()) {
                        System.out.println("⚠️ No tasks to delete.");
                        break;
                    }
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = sc.nextInt();
                    if (deleteIndex > 0 && deleteIndex <= tasks.size()) {
                        Task removed = tasks.remove(deleteIndex - 1);
                        System.out.println("🗑 Task '" + removed.name + "' deleted.");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                    break;

                case 5: // Exit
                    running = false;
                    System.out.println("👋 Exiting To-Do List. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
