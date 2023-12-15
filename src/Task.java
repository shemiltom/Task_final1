import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean complete;
    private String category;

    public Task(String description, String category) {
        this.description = description;
        this.complete = false;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return complete;
    }

    public String getCategory() {
        return category;
    }

    public void markAsComplete() {
        this.complete = true;
    }
}

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private List<String> categories = new ArrayList<>();

    public TaskManager() {
        categories.add("work");
        categories.add("shopping");
        categories.add("personal");
    }

    public void addTask(String description, int categoryIndex) {
        if (isValidCategoryIndex(categoryIndex)) {
            String category = categories.get(categoryIndex - 1);
            Task task = new Task(description, category);
            tasks.add(task);
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Invalid category index. Please choose a valid category.");
        }
    }

    public void viewTasks() {
        viewTasksByCategory(""); // View all tasks
    }

    public void viewTasksByCategory(String category) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\nTask List" + (category.isEmpty() ? "" : " for Category: " + category));
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                if (category.isEmpty() || category.equalsIgnoreCase(task.getCategory())) {
                    String status = task.isComplete() ? "Complete" : "Incomplete";
                    System.out.println((i + 1) + ". " + task.getDescription() + " - " + status);
                }
            }
        }
    }

    public void markAsComplete(int taskIndex) {
        if (taskIndex < 1 || taskIndex > tasks.size()) {
            System.out.println("Invalid task index.");
        } else {
            Task task = tasks.get(taskIndex - 1);
            task.markAsComplete();
            System.out.println("Task marked as complete!");
        }
    }

    public void markAsCompleteByCategory(String category, int taskIndex) {
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (category.equalsIgnoreCase(task.getCategory())) {
                count++;
                if (count == taskIndex) {
                    task.markAsComplete();
                    System.out.println("Task marked as complete!");
                    return;
                }
            }
        }
        System.out.println("Invalid task index for the specified category.");
    }

    public void deleteTask(int taskdelIndex) {
        if (taskdelIndex < 1 || taskdelIndex > tasks.size()) {
            System.out.println("Invalid task index.");
        } else {
            Task task = tasks.remove(taskdelIndex - 1);
            System.out.println("Task removed successfully");
        }
    }

    public void deleteTaskByCategory(String category, int taskdelIndex) {
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (category.equalsIgnoreCase(task.getCategory())) {
                count++;
                if (count == taskdelIndex) {
                    tasks.remove(i);
                    System.out.println("Task removed successfully");
                    return;
                }
            }
        }
        System.out.println("Invalid task index for the specified category.");
    }

    private boolean isValidCategoryIndex(int categoryIndex) {
        return categoryIndex >= 1 && categoryIndex <= categories.size();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<String> getCategories() {
        return categories;
    }
}


