package com.twu.biblioteca;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.ObjectCatalog;
import com.twu.biblioteca.library.ObjectToRent;
import com.twu.biblioteca.library.objectsToRent.Book;
import com.twu.biblioteca.library.objectsToRent.Movie;
import com.twu.biblioteca.utils.Menu;
import com.twu.biblioteca.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static Utils utils = new Utils();

    public static void main(String[] args) {
        ObjectCatalog objectCatalog = new ObjectCatalog();
        objectCatalog.uploadObjectsToRent(getMyListOfObjectsToRentExisting());
        Librarian librarian = new Librarian(objectCatalog);
        Menu menu = new Menu(librarian);
        System.out.println(ObjectCatalog.getWelcomeMessage());
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
