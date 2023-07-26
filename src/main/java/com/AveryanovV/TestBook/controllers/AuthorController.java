package com.AveryanovV.TestBook.controllers;
import com.AveryanovV.TestBook.dto.AuthorBookInfoDTO;
import com.AveryanovV.TestBook.dto.AuthorDTO;
import com.AveryanovV.TestBook.entities.Author;
import com.AveryanovV.TestBook.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        List<AuthorDTO> authorDTOs = authors.stream()
                .map(AuthorDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(authorDTOs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            AuthorDTO authorDTO = new AuthorDTO(author);
            return new ResponseEntity<>(authorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author newAuthor = convertToEntity(authorDTO);
        Author savedAuthor = authorService.saveAuthor(newAuthor);
        AuthorDTO savedAuthorDTO = new AuthorDTO(savedAuthor);
        return new ResponseEntity<>(savedAuthorDTO, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        Author existingAuthor = authorService.getAuthorById(id);
        if (existingAuthor != null) {
            Author updatedAuthor = convertToEntity(authorDTO);
            updatedAuthor.setId(id);
            Author savedAuthor = authorService.saveAuthor(updatedAuthor);
            AuthorDTO savedAuthorDTO = new AuthorDTO(savedAuthor);
            return new ResponseEntity<>(savedAuthorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/booksWithTotalCopies")
    public ResponseEntity<List<AuthorBookInfoDTO>> getAuthorsWithTotalBooksAtLeast(@RequestParam("minTotalCopies") int minTotalCopies) {
        List<Object[]> authorsWithTotalBooks = authorService.getAuthorsWithTotalBooksAtLeast(minTotalCopies);

        List<AuthorBookInfoDTO> authorBookInfoDTOs = new ArrayList<>();
        for (Object[] authorWithTotalBooks : authorsWithTotalBooks) {
            Author author = (Author) authorWithTotalBooks[0];
            Long totalBooks = (Long) authorWithTotalBooks[1];

            AuthorBookInfoDTO authorBookInfoDTO = new AuthorBookInfoDTO();
            authorBookInfoDTO.setAuthorName(author.getLastName() + " " + author.getFirstName());
            authorBookInfoDTO.setTotalBooks(totalBooks.intValue());

            authorBookInfoDTOs.add(authorBookInfoDTO);
        }

        return new ResponseEntity<>(authorBookInfoDTOs, HttpStatus.OK);
    }


    private Author convertToEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        return author;
    }


}
