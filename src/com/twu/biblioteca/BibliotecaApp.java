package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static Utils utils = new Utils();

    public static void main(String[] args) {
        Library library = new Library();
        library.uploadObjectsToRent(getMyListOfObjectsToRentExisting());
        Librarian librarian = new Librarian(library);
        Menu menu = new Menu(librarian);
        System.out.println(Library.getWelcomeMessage());
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

    private static List<ObjectToRent> getMyListOfObjectsToRentExisting() {
        List<ObjectToRent> booksAndMoviesToRent = new ArrayList();
        booksAndMoviesToRent.add(new Book("The Canterbury Tales", "Geoffrey Chaucer", 1400));
        booksAndMoviesToRent.add(new Book("Don Quixote", "Miguel de Cervantes", 1605));
        booksAndMoviesToRent.add(new Book("Things Fall Apart", "Chinua Achebe", 1958));
        booksAndMoviesToRent.add(new Book("The Divine Comedy", "Dante Alighieri", 1308));
        booksAndMoviesToRent.add(new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 9.3));
        booksAndMoviesToRent.add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 9.2));
        booksAndMoviesToRent.add(new Movie("The Godfather: Part II", 1974, "Francis Ford Coppola", 9));
        booksAndMoviesToRent.add(new Movie("Star Wars", 1977, "George Lucas"));
        return booksAndMoviesToRent;
    }

    private static boolean isTheOptionEnteredNonZero(String optionNumber) {
        return utils.parseInputToInt(optionNumber) != 0;
    }

    private static boolean isTheOptionEnteredOnTheRangeOfMenuOptions(String optionNumber) {
        return utils.parseInputToInt(optionNumber) >= 0 && utils.parseInputToInt(optionNumber) <= 3;
    }
}
