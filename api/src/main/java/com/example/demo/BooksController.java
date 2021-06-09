package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping
    private Flux<Book> getBooks() {
        Book[] books = {
                new Book("George Foster", "How not to suck"),
                new Book("David Goggins", "Hard to kill")
        };
        return Flux.fromArray(books);
    }

    public static final record Book(String author, String title) {
    }
}
