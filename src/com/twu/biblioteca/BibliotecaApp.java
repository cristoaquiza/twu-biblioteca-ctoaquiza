package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static Library library = new Library();
    private static Menu menu = new Menu(library);
    private static Utils utils = new Utils();

    public static void main(String[] args) {
        System.out.println(Library.getWelcomeMessage());
        library.setBooks(getMyListOfBooksExisting());
        String optionNumber = "";
        do {
            System.out.println(menu.printMenu());
            System.out.println("Enter the option number to do: ");
            Scanner read = new Scanner(System.in);
            optionNumber = read.nextLine();
            if (isTheOptionEnteredOnTheRangeOfMenuOptions(optionNumber)) {
                menu.doTheChoice(utils.parseInputToInt(optionNumber));
            }
            else {
                System.out.println("Select a valid option!");
            }
        } while (isTheOptionEnteredNonZero(optionNumber));
    }

    private static List<Book> getMyListOfBooksExisting() {
        List<Book> myBooks = new ArrayList();
        myBooks.add(new Book("The Canterbury Tales", "Geoffrey Chaucer", 1400));
        myBooks.add(new Book("Don Quixote", "Miguel de Cervantes", 1605));
        myBooks.add(new Book("Things Fall Apart", "Chinua Achebe", 1958));
        myBooks.add(new Book("The Divine Comedy", "Dante Alighieri", 1308));
        return myBooks;
    }

    private static boolean isTheOptionEnteredNonZero(String optionNumber) {
        return utils.parseInputToInt(optionNumber) != 0;
    }

    private static boolean isTheOptionEnteredOnTheRangeOfMenuOptions(String optionNumber) {
        return utils.parseInputToInt(optionNumber) >= 0 && utils.parseInputToInt(optionNumber) <= 3;
    }
}
