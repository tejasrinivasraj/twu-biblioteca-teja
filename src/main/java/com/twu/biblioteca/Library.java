package com.twu.biblioteca;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Library {
    private List<Book> libraryBooks;
    private List<Movie> libraryMovies;
    private Librarian librarian;
    private ReadWriteOperation writeOperation;
    private List<Movie> checkedOutMovies;

    public Library(List<Book> libraryBooks, List<Movie> libraryMovies, Librarian librarian, ReadWriteOperation writeOperation, List<Movie> checkedOutMovies) {

        this.libraryBooks = libraryBooks;
        this.libraryMovies = libraryMovies;
        this.librarian = librarian;
        this.writeOperation = writeOperation;
        this.checkedOutMovies = checkedOutMovies;
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
        AtomicBoolean success = new AtomicBoolean(false);
        libraryMovies.stream().filter(movie -> movie.isName(movieName)).findFirst().ifPresent(movie -> {
            libraryMovies.remove(movie);
            checkedOutMovies.add(movie);
            success.set(true);
        });
        writeOperation.display(success.get() ? Constants.CHECK_OUT_MOVIE_SUCCESS : Constants.CHECK_OUT_MOVIE_FAILED);
    }

    public void returnMovie(String movieName) {
        AtomicBoolean success = new AtomicBoolean(false);
        checkedOutMovies.stream().filter(movie -> movie.isName(movieName)).findFirst().ifPresent(movie -> {
            libraryMovies.add(movie);
            checkedOutMovies.remove(movie);
            success.set(true);
        });
        writeOperation.display(success.get() ? Constants.RETURN_MOVIE_SUCCESS : Constants.RETURN_MOVIE_FAILED);
    }
}
