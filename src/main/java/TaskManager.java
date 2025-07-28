import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {

    private List<Task> tasks= new ArrayList<>();
    File taskFile = new File("src/main/resources/tasks.txt");

    public void loadTasks(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(taskFile));
            String x;
            while((x = reader.readLine())!=null){
                String[] s = x.split("\\|");
                tasks.add(new Task(Integer.parseInt(s[0].trim()), s[1].trim(), Boolean.parseBoolean(s[2].trim())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Tasks file not found");
        } catch (IOException e) {
            System.out.println("Error in file " + e);
        }
    }

    public void printTasks(){
        System.out.println("ID" + " | " + "Task" + " | " + "is Completed");
        tasks.forEach(t -> System.out.println(t.getID() + " | " + t.getTask() + " | " + t.isCompleted()));
    }

    public void reloadFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile, false));
            tasks.forEach(t -> {
                try {
                    writer.write(t.getID() + " | " + t.getTask() + " | " + t.isCompleted());
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Error reloading " + e);
                }
            });
            writer.close();
        } catch (IOException e){
            System.out.println("Error in file " + e);
        }
    }

    public void addTask(String task){
        Task newtask = new Task(tasks.size()+1, task, false);
        tasks.add(newtask);
    }

    public void deleteTask(int ID){
        tasks.removeIf(t -> t.getID()==ID);
    }

    public void markTaskAsComplete(int ID){
        tasks.forEach(
                n -> {
                    if(n.getID()==ID) n.setCompleted(true);
                }
        );
    }

}
