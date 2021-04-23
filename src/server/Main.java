package server;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] database = new String[100];

        label:
        while (true) {
            int cell = 0;
            String text = "";
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            String command = inputArr[0];

            if (inputArr.length == 2) {
                cell = Integer.parseInt(inputArr[1]);
            }
            else if (inputArr.length == 3) {
                cell = Integer.parseInt(inputArr[1]);
                text = inputArr[2];
            }
            else if (inputArr.length > 3) {
                cell = Integer.parseInt(inputArr[1]);
                text += Arrays.stream(inputArr).skip(2).collect(Collectors.joining(" "));
            }

            switch (command) {
                case "exit":
                    break label;
                case "get":
                    if (cell < 1 || cell > 100) {
                        System.out.println("ERROR");
                    } else {
                        if (database[cell - 1] == null) {
                            System.out.println("ERROR");
                        } else {
                            System.out.println(database[cell - 1]);
                        }
                    }
                    break;
                case "set":
                    if (cell < 1 || cell > 100) {
                        System.out.println("ERROR");
                    } else {
                        database[cell - 1] = text;
                        System.out.println("OK");
                    }
                    break;
                case "delete":
                    if (cell < 1 || cell > 100) {
                        System.out.println("ERROR");
                    } else {
                        database[cell - 1] = null;
                        System.out.println("OK");
                    }
                    break;
                default:
                    System.out.println("Please enter correct command");
                    break;
            }
        }
    }
}
