package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;
    private Utils utils = new Utils();
    private List movies = new ArrayList();

    public static String getWelcomeMessage() {
        return "Welcome to The Bangalore Public Library Management System\n\t\t___ Biblioteca is available ___";
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    public String getTheBooksListReadyToPrint() {
        String print = "--- LIST BOOKS ---\n";
        for(int i = 0; i < this.books.size(); i++) {
            if(!this.getBooks().get(i).getCheckedOut())
                print += getNumberedBookToPrint(i);
        }
        print += "--- END LIST BOOKS ---\n";
        return print;
    }

    public boolean checkoutBook() {
        System.out.print(this.getTheBooksListReadyToPrint());
        System.out.println("Enter the book number to checkout: ");
        Scanner read = new Scanner(System.in);
        String bookNumber = read.nextLine();
        if(isTheBookNumberABookValidToCheckout(bookNumber)) {
            doCkeckOutBook(getIndexFromInput(bookNumber));
            return true;
        }
        return false;
    }

    private boolean isTheBookNumberABookValidToCheckout(String bookNumber) {
        return getIndexFromInput(bookNumber) >= 0 && getIndexFromInput(bookNumber) <= this.books.size() && !this.books.get(getIndexFromInput(bookNumber)).getCheckedOut();
    }

    public void doCkeckOutBook(int index) {
        this.books.get(index).setCheckedOut(true);
    }

    public String getTheBooksCheckedOutReadyToPrint() {
        String print = "--- BOOKS CHECKED OUT ---\n";
        for(int i = 0; i < this.books.size(); i++) {
            if(this.getBooks().get(i).getCheckedOut())
                print += getNumberedBookToPrint(i);
        }
        print += "--- END BOOKS CHECKED OUT ---\n";
        return print;
    }

    private String getNumberedBookToPrint(int i) {
        return (i+1) + ". " + this.books.get(i).toString() + "\n";
    }

    public boolean returnBook() {
        System.out.print(this.getTheBooksCheckedOutReadyToPrint());
        System.out.println("Enter the book number to return: ");
        Scanner read = new Scanner(System.in);
        String bookNumber = read.nextLine();
        if(isTheBookNumberABookValidToReturn(bookNumber)) {
            doReturnBook(getIndexFromInput(bookNumber));
            return true;
        }
        return false;
    }

    private int getIndexFromInput(String bookNumber) {
        return utils.parseInputToInt(bookNumber) - 1;
    }

    private boolean isTheBookNumberABookValidToReturn(String bookNumber) {
        return getIndexFromInput(bookNumber) >= 0 && getIndexFromInput(bookNumber) <= this.books.size() && this.books.get(getIndexFromInput(bookNumber)).getCheckedOut();
    }

    public void doReturnBook(int index) {
        this.books.get(index).setCheckedOut(false);
    }

    public List getMovies() {
        movies.add(new Object());
        return movies;
    }
}
