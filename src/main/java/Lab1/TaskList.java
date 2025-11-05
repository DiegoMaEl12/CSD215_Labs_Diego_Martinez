package Lab1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *  DTO for Task List
 */
public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Constructor for TaskList
     */
    TaskList(){}

    /**
     *
     * @return the list of tasks
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     *
     * @param task the task to be added to the list
     */
    public void addTask(Task task){
        tasks.add(task);
    }

    /**
     * Deletes a task from the list
     * @param task the task to be deleted
     */
    public void removeTask(Task task){
        tasks.remove(task);
    }

    /**
     * Deletes all completed tasks from the list
     * @param tasks the list of tasks
     * @return the list of tasks without completed tasks
     */
    public TaskList deleteCompletedTasks(TaskList tasks){
        for(int i = 0; i < tasks.getTasks().size(); i++){
            if(tasks.getTasks().get(i).getStatus()){
                tasks.removeTask(tasks.getTasks().get(i));
                i--;
            }
        }
        return tasks;
    }

    /**
     *
     * @return the bytes representation of the task list
     */
    public byte[] getBytes() {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task.getStatus()).append(";").append(task.getDescription()).append("\n");
        }
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }
}
