package com.AveryanovV.TestBook.dto;

import com.AveryanovV.TestBook.entities.Author;
import com.AveryanovV.TestBook.entities.Book;
import com.AveryanovV.TestBook.entities.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class BookDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String nameBook;
    private int year;
    private int count;
    private Author author;
    private List<Genre> genres;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.nameBook = book.getNameBook();
        this.year = book.getYear();
        this.count = book.getCount();
        this.author = book.getAuthor();
        this.genres = book.getGenres();
    }
}
