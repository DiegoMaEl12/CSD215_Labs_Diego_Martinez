package Lab1;


import static Lab1.Console.*;

public class App {
    static void run() {
        var tasks = new TaskList();
        printWelcomeMessage();
        while (true) {
            printTasks(tasks);
            printMenu();
            var input = promptForSelection();
            switch (input) {
                case "a":
                    var task = promptForTask();
                    tasks.addTask(task);
                    break;
                case "c":
                    if (tasks.getTasks().isEmpty()){
                        println("You don't have pending tasks!");
                        break;
                    }
                    println("Please enter the index of the task you want to complete: ");
                    printTasks(tasks);
                    var index = promptForTaskIndex(tasks);
                    tasks.getTasks().get(index-1).changeStatus(true);
                    break;
                case "d":
                    tasks = tasks.deleteCompletedTasks(tasks);
                    break;
                case "q":
                    println("Bye!");
                    return;
                default:
                    println("Invalid input. Please try again.");
                    break;
            }
        }
    }
}
