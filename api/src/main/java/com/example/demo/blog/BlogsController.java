/*
 * Copyright (c) 2021.
 * This file is the property of Whitespace and may not be used, duplicated, or shared.
 */

package com.example.demo.book;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping
    @CrossOrigin
    private Flux<Book> getBooks() {
        Book[] books = {
                new Book("George Foster", "How not to suck"),
                new Book("Jordan Peterson", "12 Rules for Life"),
                new Book("Jordan Peterson", "12 More Rules for Life"),
                new Book("David Goggins", "Hard to kill")
        };
        return Flux.fromArray(books);
    }

    public static final class Book {
        private final String author;
        private final String title;

        public Book(String author, String title) {
            this.author = author;
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }
    }
}
