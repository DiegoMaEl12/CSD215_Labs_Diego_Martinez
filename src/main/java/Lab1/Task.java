package Lab1;

/**
 * Represents a Task with a description and status
 */
public class Task {
    private final String description;
    private boolean status;

    /**
     * Constructor for Task
     * @param description the description of the task
     */
    public Task(String description){
        this.description = description;
        this.status = false;
    }

    /**
     *
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the status of the task
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Updates the status of the task
     * @param status the new status of the task
     */
    public void setStatus(boolean status){
        this.status = status;
    }

    /**
     *
     * @return the task converted to a string
     */
    @Override
    public String toString(){
        return (status ? "[✓]" : "[ ]" ) + description;
    }
}
