package Lab1;

import java.util.ArrayList;

public class Console {
    public static void println(String message){
        System.out.println(message);
    }

    public static void printWelcomeMessage(){
        println("Welcome to the Java ToDo list app!!!");
        println("-----------------------------------");
    }

    public void printTasks(ArrayList<String> tasks){
        for(int i=0; i<tasks.size(); i++){
            println((i+1) + ". " + tasks.get(i));
        }
    }

    public void printMenu(String prompt, String ... options){
        println(prompt);
        for (String option : options) {
            println(option.charAt(0) + " - " + option);
        }
    }




}
