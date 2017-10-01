package com.twu.biblioteca;

import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.User;
import com.twu.biblioteca.library.catalog.ObjectCatalog;
import com.twu.biblioteca.library.ObjectToRent;
import com.twu.biblioteca.library.catalog.UserCatalog;
import com.twu.biblioteca.library.objectsToRent.Book;
import com.twu.biblioteca.library.objectsToRent.Movie;
import com.twu.biblioteca.library.Menu;
import com.twu.biblioteca.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        ObjectCatalog objectCatalog = new ObjectCatalog();
        UserCatalog userCatalog = new UserCatalog();
        objectCatalog.uploadObjectsToRent(getMyListOfObjectsToRentExisting());
        userCatalog.uploadUsers(getMyListOfUsersRegistered());
        Librarian librarian = new Librarian(objectCatalog, userCatalog);
        Utils.print(Librarian.getWelcomeMessage());
        Utils.print("LOGIN USER");
        String libraryNumber = Utils.getAKeyboardInput("Enter your library number: ");
        String password = Utils.getAKeyboardInput("Enter your password: ");
        if(!librarian.isAuthorizedUser(libraryNumber, password)) refuseUserAccess();
        Menu menu = new Menu(librarian);
        int optionNumber;
        do {
            Utils.print(menu.getMenuToString());
            optionNumber = Utils.convertFromStringToInt(Utils.getAKeyboardInput("Enter the option number to do: "));
            if (!isTheOptionEnteredOnTheRangeOfMenuOptions(optionNumber)) {
                Utils.printNotification("Select a valid option!");
                continue;
            }
            menu.performTheChosen(optionNumber, libraryNumber);
        } while (isNotTheExitOption(optionNumber));
    }

    private static void refuseUserAccess() {
        Utils.print("BAD LOGIN, credentials don't match");
        System.exit(0);
    }

    private static List<User> getMyListOfUsersRegistered() {
        List<User> usersRegistered = new ArrayList();
        usersRegistered.add(new User("John Smith", "jsmith@email.com", "5932857045","000-0000", "000-0000"));
        usersRegistered.add(new User("John Cow", "jcow@email.com", "5932857046","123-0000", "asd#fgh123"));
        usersRegistered.add(new User("John Run", "jrunh@email.com", "5932857047","123-0001", "qwe#ert123"));
        return usersRegistered;
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

    private static boolean isNotTheExitOption(int optionNumber) {
        return optionNumber != Menu.NUMBER_OF_EXIT_OPTION;
    }

    private static boolean isTheOptionEnteredOnTheRangeOfMenuOptions(int optionNumber) {
        return optionNumber >= 0 && optionNumber <= 4;
    }
}
