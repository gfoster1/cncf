/*
 * Copyright (c) 2021.
 * This file is the property of Whitespace and may not be used, duplicated, or shared.
 */

package com.example.demo.blog;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.Month;


@RestController
@RequestMapping("/blogs")
public class BlogsController {

    @GetMapping
    @CrossOrigin
    private Flux<Blog> getBlogs() {
        LocalDate localDate = LocalDate.of(2021, Month.JULY, 19);
        Blog[] blogs = {
                new Blog("Lopse ipson", "George Foster", "How not to suck", localDate),
                new Blog("Lopse ipson", "Jordan Peterson", "12 Rules for Life", localDate),
                new Blog("Lopse ipson", "Jordan Peterson", "12 More Rules for Life", localDate),
                new Blog("Lopse ipson", "David Goggins", "Hard to kill", localDate)
        };
        return Flux.fromArray(blogs);
    }

    public static final class Blog {
        private final String text;
        private final String title;
        private final String author;
        private final LocalDate localDate;

        public Blog(String text, String author, String title, LocalDate localDate) {
            this.text = text;
            this.author = author;
            this.title = title;
            this.localDate = localDate;
        }

        public String getText() {
            return text;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }
    }
}
