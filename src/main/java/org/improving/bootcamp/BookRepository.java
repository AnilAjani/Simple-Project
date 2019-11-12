package org.improving.bootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepository(){
        books.add(new Book("the Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("Harry Potter and the order of the Phoenix", "J.K. Rawling"));
    }

    public void add(Book book){
        books.add(book);
    }
    public void remove (Book book){
        books.remove(book);
    }
    public List<Book> getBooks(){
        return Collections.unmodifiableList(books);
    }
}
