package org.improving.bootcamp;

import javax.validation.constraints.NotEmpty;

public class Book {
    @NotEmpty (message = "Enter Title")
    private final String title;
    @NotEmpty (message = "Enter Author")
    private final String author;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


}
