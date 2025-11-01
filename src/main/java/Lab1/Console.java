package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    public static void println(String message){
        System.out.println(message);
    }

    public static void printWelcomeMessage(){
        println("Welcome to the Java ToDo list app!!!");
        println("-----------------------------------");
    }

    public void printTasks(ArrayList<String> tasks){
        if(tasks.isEmpty()){
            println("You don't have pending tasks!");
        }
        else{
            println("Your tasks: ");
            for(int i=0; i<tasks.size(); i++){
                println((i+1) + ". " + tasks.get(i));
            }
        }
    }

    public static void printMenu(){
        println("What do you want to do?");
        println("a - Add task");
        println("c - Complete task");
        println("d - Delete completed tasks");
        println("q - Exit");
    }

    public static String getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("a") && !input.equals("c") && !input.equals("d") && !input.equals("q")){
            println("Invalid input. Please try again.");
            input = getInput();
        }
        return input;
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
