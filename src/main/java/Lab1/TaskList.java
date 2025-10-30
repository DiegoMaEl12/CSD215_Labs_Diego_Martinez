package Lab1;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(ArrayList<Task> tasks) {
        TaskList.tasks = tasks;
    }

    public static void addTask(Task task){
        tasks.add(task);
    }

    public static void removeTask(Task task){
        tasks.remove(task);
    }
}
