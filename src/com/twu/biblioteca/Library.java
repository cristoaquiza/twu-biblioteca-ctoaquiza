package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;
    private Utils utils = new Utils();

    public Library() {
        this.books = loadBooks();
    }

    public String salute() {
        return "## Welcome to The Bangalore Public Library Management System ##";
    }

    public List<Book> loadBooks() {
        List<Book> booksLoaded = new ArrayList<Book>();
        booksLoaded.add(new Book("Peter and Wendy", "J. M. Barrie", 1911));
        booksLoaded.add(new Book("Robinson Crusoe", "Daniel Defoe", 1719));
        booksLoaded.add(new Book("Gulliver's Travels", "Jonathan Swift", 1726));
        return booksLoaded;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public String printBooks() {
        String print = "--- LIST BOOKS ---\n";
        for(int i = 0; i < this.books.size(); i++) {
            if(!this.getBooks().get(i).getCheckedOut())
                print += (i+1) + ". " + this.books.get(i).toString() + "\n";
        }
        print += "--- END LIST BOOKS ---\n";
        return print;
    }

    public void checkoutBook() {
        System.out.print(this.printBooks());
        System.out.println("Enter the book number to checkout: ");
        Scanner read = new Scanner(System.in);
        String bookNumber = read.nextLine();
        if(utils.parseInputToInt(bookNumber) -1 >= 0) {
            doCkeckOutBook(utils.parseInputToInt(bookNumber) - 1);
        }
    }

    public void doCkeckOutBook(int index) {
        this.books.get(index).setCheckedOut(true);
    }
}
