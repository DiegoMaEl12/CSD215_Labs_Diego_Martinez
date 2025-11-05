package Lab1;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static Lab1.Console.*;

/**
 * Main application class
 */
public class App {

    /**
     * Runs the main application loop
     */
    static void run() {
        Path path = Paths.get(".", "src","main","java","lab1","Tasks.txt");
        var tasks = readFile(path);
        printWelcomeMessage();
        while (true) {
            println("Your tasks: ");
            printTasks(tasks);
            printMenu();
            var input = promptForSelection();
            switch (input) {
                case "a":
                    var task = promptForTask();
                    tasks.addTask(task);
                    println("Task added successfully!");
                    break;
                case "c":
                    if (tasks.getTasks().isEmpty() || tasks.getTasks().stream().allMatch(Task::getStatus)){
                        println("You don't have pending tasks!");
                        break;
                    }
                    println("Please enter the index of the task you want to complete: (Press Enter to go back)");
                    printTasks(tasks);
                    var index = promptForTaskIndex(tasks);
                    if (index == null){
                        println("Returning to menu");
                        println("-----------------------");
                        println("-----------------------");
                        break;
                    }
                    if(tasks.getTasks().get(index-1).getStatus()){
                        println("Task already completed!");
                        break;
                    }
                    tasks.getTasks().get(index-1).setStatus(true);
                    println("Task completed successfully!");
                    break;
                case "d":
                    tasks = tasks.deleteCompletedTasks(tasks);
                    println("Completed tasks removed successfully!");
                    break;
                case "q":
                    println("Bye!");
                    try{
                        Files.write(path, tasks.getBytes());
                    } catch (Exception e){
                        println("Error writing file. Please try again.");
                    }
                    return;
                default:
                    println("Invalid input. Please try again.");
                    break;
            }

        }
    }
}
