import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class TaskManagementSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TaskManager taskManager = new TaskManager();

            while (true) {
                System.out.println("\nTask Management System\n");
                System.out.println("1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Mark as Complete");
                System.out.println("4. Remove Task");
                System.out.println("0. Exit");

                try {
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Available categories:");
                            for (int i = 0; i < taskManager.getCategories().size(); i++) {
                                System.out.println((i + 1) + ". " + taskManager.getCategories().get(i));
                            }
                            System.out.print("Enter category index: ");
                            int categoryIndexAdd = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline
                            System.out.print("Enter task description: ");
                            String taskDescriptionAdd = scanner.nextLine().trim();
                            taskManager.addTask(taskDescriptionAdd, categoryIndexAdd);
                            break;
                        case 2:
                            System.out.println("Available categories:");
                            for (int i = 0; i < taskManager.getCategories().size(); i++) {
                                System.out.println((i + 1) + ". " + taskManager.getCategories().get(i));
                            }
                            System.out.print("Enter category index to view tasks: ");
                            int categoryIndexView = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline
                            String viewCategory = taskManager.getCategories().get(categoryIndexView - 1);
                            taskManager.viewTasksByCategory(viewCategory);
                            break;
                        case 3:
                            System.out.println("Available categories:");
                            for (int i = 0; i < taskManager.getCategories().size(); i++) {
                                System.out.println((i + 1) + ". " + taskManager.getCategories().get(i));
                            }
                            System.out.print("Enter category index to view tasks: ");
                            int categoryIndexComplete = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline
                            String completeCategory = taskManager.getCategories().get(categoryIndexComplete - 1);
                            taskManager.viewTasksByCategory(completeCategory);
                            System.out.print("Enter the number of the task to mark as complete: ");
                            int completeTaskIndex = scanner.nextInt();
                            taskManager.markAsCompleteByCategory(completeCategory, completeTaskIndex);
                            break;
                        case 4:
                            System.out.println("Available categories:");
                            for (int i = 0; i < taskManager.getCategories().size(); i++) {
                                System.out.println((i + 1) + ". " + taskManager.getCategories().get(i));
                            }
                            System.out.print("Enter category index to view tasks: ");
                            int categoryIndexDelete = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline
                            String deleteCategory = taskManager.getCategories().get(categoryIndexDelete - 1);
                            taskManager.viewTasksByCategory(deleteCategory);
                            System.out.print("Enter the number of the task to be removed: ");
                            int deleteTaskIndex = scanner.nextInt();
                            taskManager.deleteTaskByCategory(deleteCategory, deleteTaskIndex);
                            break;
                        case 0:
                            System.out.println("Exiting program. Goodbye!");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
    }
}
