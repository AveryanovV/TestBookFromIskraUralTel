package com.AveryanovV.TestBook.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class BookInfoDTO {
    private String bookName;
    private String authorName;
    private String genreName;

    public BookInfoDTO(String bookName, String authorName, String genreName) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genreName = genreName;
    }
}