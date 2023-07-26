package com.AveryanovV.TestBook.controllers;
import com.AveryanovV.TestBook.dto.BookDTO;
import com.AveryanovV.TestBook.dto.BookInfoDTO;
import com.AveryanovV.TestBook.entities.Book;
import com.AveryanovV.TestBook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookDTO> bookDTOs = books.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            BookDTO bookDTO = new BookDTO(book);
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book newBook = convertToEntity(bookDTO);
        Book savedBook = bookService.saveBook(newBook);
        BookDTO savedBookDTO = new BookDTO(savedBook);
        return new ResponseEntity<>(savedBookDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook != null) {
            Book updatedBook = convertToEntity(bookDTO);
            updatedBook.setId(id);
            Book savedBook = bookService.saveBook(updatedBook);
            BookDTO savedBookDTO = new BookDTO(savedBook);
            return new ResponseEntity<>(savedBookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/booksByGenreContaining")
    public ResponseEntity<List<BookInfoDTO>> getBooksByGenreContaining(@RequestParam("genreKeyword") String genreKeyword) {
        List<BookInfoDTO> booksByGenre = bookService.getBooksByGenreContaining(genreKeyword);
        return new ResponseEntity<>(booksByGenre, HttpStatus.OK);
    }


    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setNameBook(bookDTO.getNameBook());
        book.setYear(bookDTO.getYear());
        book.setCount(bookDTO.getCount());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenres(bookDTO.getGenres());
        return book;
    }
}

