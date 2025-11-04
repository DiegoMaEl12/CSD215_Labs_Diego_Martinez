package Lab1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *  Console class for input and output
 */
public class Console {
    public static void println(String message){
        System.out.println(message);
    }

    /**
     * Prints the welcome message
     */
    public static void printWelcomeMessage(){
        println("Welcome to the Java ToDo list app!!!");
        println("-----------------------------------");
    }

    /**
     * Prints the menu options
     */
    public static void printMenu(){
        println("What do you want to do?");
        println("a - Add task");
        println("c - Complete task");
        println("d - Delete completed tasks");
        println("q - Quit");
    }

    /**
     * Prompts the user for a selection from the menu
     * @return The selection made by the user
     */
    public static String promptForSelection(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("a") && !input.equals("c") && !input.equals("d") && !input.equals("q")){
            println("Invalid input. Please try again.");
            input = promptForSelection();
        }
        return input;
    }

    /**
     * Prompts the user for a task index
     * @param tasks The list of tasks
     * @return The index of the task to be completed, or null if the user wants to go back
     */
    public static Integer promptForTaskIndex(TaskList tasks){
        Scanner sc = new Scanner(System.in);
        while(true) {
            var index = sc.nextLine().trim();
            if(index.isEmpty()) {
                return null;
            }
            try{
                int i = Integer.parseInt(index);
                if(i <= 0 || i > tasks.getTasks().size()){
                    println("Invalid index. Please try again.");
                } else {
                    return i;
                }
            } catch(NumberFormatException e){
                println("Invalid index. Please enter a number or press Enter to go back");
            }
        }
    }

    /**
     * Prints the list of tasks
     * @param tasks The list of tasks
     */
    public static void printTasks(TaskList tasks){
        if (tasks.getTasks().isEmpty()){
            println("You don't have any tasks!");
            return;
        }
        for(int i = 0; i < tasks.getTasks().size(); i++){
            println((i+1) + ". " + tasks.getTasks().get(i).toString());
        }
    }

    /**
     * Prompts the user for a task description
     * @return The task created from the description
     */
    public static Task promptForTask(){
        println("Please enter the description of the task: ");
        Scanner sc = new Scanner(System.in);
        String description = sc.nextLine();
        while(description.isEmpty()){
            println("The task description cannot be empty.");
            description = sc.nextLine();
        }
        return new Task(description);
    }

    /**
     * Reads the tasks from a file
     * @param path The path to the file
     * @return The list of tasks read from the file
     */
    public static TaskList readFile(Path path){
        var tasks = new TaskList();
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
            }
            var lines = Files.readAllLines(path);
            for(var line : lines){
                if (line.isBlank()) continue;
                String[] parts = line.split(";", 2);
                boolean completed = Boolean.parseBoolean(parts[0]);
                String description = parts.length > 1 ? parts[1] : "";
                Task task = new Task(description);
                task.setStatus(completed);
                tasks.addTask(task);
            }
        } catch (Exception e){
            println("Error reading file. Please try again.");
            return readFile(path);
        }
        return tasks;
    }
}
