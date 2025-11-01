package Lab1;

public class Task {
    private String description;
    private int id;
    private boolean completed ;

    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public Task(String description){
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeTask(boolean completed) {
        this.completed = completed;
    }
}
