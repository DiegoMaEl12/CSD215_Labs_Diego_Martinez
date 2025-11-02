package Lab1;

public class Task {
    private final String description;
    private boolean status;

    public Task(String description){
        this.description = description;
        this.status = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public void changeStatus(boolean status) {
        this.status = status;
    }
}
