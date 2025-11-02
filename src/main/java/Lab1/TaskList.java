package Lab1;

import java.util.ArrayList;

public class TaskList {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    TaskList(){}

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public int getIndex(Task task){
        return tasks.indexOf(task);
    }

    public TaskList deleteCompletedTasks(TaskList tasks){
        for(int i = 0; i < tasks.getTasks().size(); i++){
            if(tasks.getTasks().get(i).getStatus()){
                tasks.removeTask(tasks.getTasks().get(i));
                i--;
            }
        }
        return tasks;
    }

}
