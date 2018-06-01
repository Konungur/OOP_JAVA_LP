package com.company;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static String s = scan.next();

    public static void main(String[] args) {
        if (args.equals("-h") || args.equals("-help")) {
            return;
        }
        String command = command();
        switch (command) {
            case "a":
                display(args);
                break;
            case "b":
                process(s);
                break;
            case "c":
                result();
                break;
            case "d":
                System.out.println("The end!");
                return;
            default:
                System.out.println("Error, wrong operation!");
                break;
        }

        main(args);
    }

    private static String command () {
        System.out.println("Choose the command: " +
                "dd. display data; " +
                "pd. process data; " +
                "dr. display result; " +
                "end. end program.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void display (String args []) {
        if (args.length > 1) {
            System.out.println(s);
        } else
            System.out.println("Invalid data!");
    }

    private static void process (String s) {
        s.replaceAll("[^a-zA-Z0-9\\s]", "");
        s.replaceAll("( )+", " ");

    }

    private static void result () {
        System.out.println(s);
    }
}