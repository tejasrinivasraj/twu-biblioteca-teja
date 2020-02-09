package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Librarian {

    private List<Book> collection = new ArrayList<>();

    void addToCollection(Book book) {
        collection.add(book);
    }
}
