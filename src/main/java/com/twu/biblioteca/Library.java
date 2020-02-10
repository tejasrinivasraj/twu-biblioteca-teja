package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> libraryBooks;
    private Librarian librarian;

    public Library(List<Book> libraryBooks, Librarian librarian) {

        this.libraryBooks = libraryBooks;
        this.librarian = librarian;
    }

    public void displayBooks() {
        libraryBooks.forEach(Book::displayInformation);
    }

    public void checkOut(String bookName) {
        Book checkOutBook = null;
        for (Book book : libraryBooks) {
            if(book.isName(bookName)) {
                librarian.addToCollection(book);
                checkOutBook = book;
                break;
            }
        }
        libraryBooks.remove(checkOutBook);
        if (checkOutBook != null)
            System.out.println(Constants.CHECKOUT_SUCCESS);
        else
            System.out.println(Constants.CHECKOUT_FAILED);
    }

    public void returnBook(String bookName) {
        Book returnedBook = librarian.returnBook(bookName);
        libraryBooks.add(returnedBook);
        System.out.println(Constants.RETURN_SUCCESS);
    }
}
