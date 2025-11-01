package Lab1;


import static Lab1.Console.*;

public class App {
    static void run() {
        var tasks = new TaskList();
        printWelcomeMessage();
        printMenu();
        while (true) {
            var input = getInput();
            switch (input) {
                case "a":
                    var task = promptForTask();
                    tasks.addTask(task);
                case "c":

            }
            break;
        }



    }
}
