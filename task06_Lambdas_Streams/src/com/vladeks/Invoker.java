package com.vladeks;

import java.util.Scanner;

public class Invoker {

    private static void pace(String str) {
        System.out.println("Pace " + str);
    }

    class Delete implements Command {

        @Override
        public void execute(String str) {
            System.out.println("Delete " + str);
        }
    }

    public static void main(String[] args) {
        Command cut = str -> System.out.println("Cut " + str);
        Command pace = Invoker::pace;
        Command save = new Command() {
            @Override
            public void execute(String str) {
                System.out.println("Save " + str);
            }
        };
        Command delete = new Invoker().new Delete();

        Scanner scanner = new Scanner(System.in);
        boolean quit = true;
        do {
            String name = scanner.nextLine();
            String param = scanner.nextLine();
            switch (name) {
                case "cut" : execute(cut, param); break;
                case "pace" : execute(pace, param); break;
                case "save" : execute(save, param); break;
                case "delete" : execute(delete, param); break;
                case "q" : quit = false; break;
                default:
                    System.out.println("No such function");
                    break;
            }
        } while (quit);



    }

    public static void execute(Command command, String param) {
        command.execute(param);
    }
}
