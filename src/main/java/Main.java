import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        manager.loadTasks();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline
            switch (choice) {
                case 1:
                    manager.printTasks();
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine();
                    manager.addTask(desc);
                    break;
                case 3:
                    System.out.print("Enter task ID to mark as complete: ");
                    int idToComplete = sc.nextInt();
                    manager.markTaskAsComplete(idToComplete);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int idToDelete = sc.nextInt();
                    manager.deleteTask(idToDelete);
                    break;
                case 5:
                    manager.reloadFile();
                    System.out.println("Exiting. Tasks saved.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
