package Lab1;

import java.util.Scanner;

public class Console {
    public static void println(String message){
        System.out.println(message);
    }

    public static void printWelcomeMessage(){
        println("Welcome to the Java ToDo list app!!!");
        println("-----------------------------------");
    }

    public static void printMenu(){
        println("What do you want to do?");
        println("a - Add task");
        println("c - Complete task");
        println("d - Delete completed tasks");
        println("q - Quit");
    }

    public static String promptForSelection(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("a") && !input.equals("c") && !input.equals("d") && !input.equals("q")){
            println("Invalid input. Please try again.");
            input = promptForSelection();
        }
        return input;
    }

    public static int promptForTaskIndex(TaskList tasks){
        try{
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            while(index < 1){
                println("The task index must be greater than 0. Please try again.");
                index = sc.nextInt();
            }
            while (index > tasks.getTasks().size()){
                println("There's no task with that index. Please try again.");
                index = sc.nextInt();
            }
            return index;
        } catch (Exception e){
            println("Invalid input. Please try again.");
            return promptForTaskIndex(tasks);
        }
    }

    public static void printTasks(TaskList tasks){
        tasks.getTasks().forEach(task -> {
            var checkMark = "[ ]";
            if(task.getStatus()){
                checkMark = "[✓]";
            }
            println((tasks.getIndex(task) + 1) + "." + checkMark + " " + task.getDescription());
        });
    }


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
}
