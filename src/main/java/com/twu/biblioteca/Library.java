package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> libraryBooks;
    private List<Movie> libraryMovies;
    private Librarian librarian;
    private ReadWriteOperation writeOperation;

    public Library(List<Book> libraryBooks, List<Movie> libraryMovies, Librarian librarian, ReadWriteOperation writeOperation) {

        this.libraryBooks = libraryBooks;
        this.libraryMovies = libraryMovies;
        this.librarian = librarian;
        this.writeOperation = writeOperation;
    }

    public void displayBooks() {
        libraryBooks.forEach(book -> writeOperation.display(book.returnInformation()));
    }

    public void checkOut(String bookName) {
        for (Book book : libraryBooks) {
            if(book.isName(bookName)) {
                librarian.addToCollection(book);
                libraryBooks.remove(book);
                writeOperation.display(Constants.CHECKOUT_SUCCESS);
                return;
            }
        }
        writeOperation.display(Constants.CHECKOUT_FAILED);
    }

    public void returnBook(String bookName) {
        Book returnedBook = librarian.returnBook(bookName);
        if (returnedBook != null) {
            libraryBooks.add(returnedBook);
            writeOperation.display(Constants.RETURN_SUCCESS);
        }
        else
            writeOperation.display(Constants.RETURN_FAILED);
    }

    public void displayMovies() {
        libraryMovies.forEach(movie -> writeOperation.display(movie.returnInformation()));
    }

    public void checkOutMovie(String movieName) {
        libraryMovies.stream().filter(movie -> movie.isName(movieName)).findFirst().ifPresent(movie -> libraryMovies.remove(movie));
    }
}
