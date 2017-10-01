package com.twu.biblioteca.utils;

import java.util.Scanner;

public class Utils {

    public static int convertFromStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }

    public static String getAKeyboardInput(String message) {
        System.out.print(message);
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printNotification(String message) {
        System.out.println("NOTIFICATION: " + message);
    }
}
