package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Librarian {

    private List<Book> collection = new ArrayList<>();

    void addToCollection(Book book) {
        collection.add(book);
    }

    public Book returnBook(String bookName) {
        for (Book book : collection) {
            if (book.isName(bookName))
                return book;
        }
        return null;
    }
}
