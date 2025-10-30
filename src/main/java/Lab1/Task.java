package Lab1;

public class Task {
    private String description;
    private int id;
    private boolean completed ;

    public Task(String description, int id, boolean completed) {
        this.description = description;
        this.id = id;
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
