package com.AveryanovV.TestBook.services;

import com.AveryanovV.TestBook.dto.BookInfoDTO;
import com.AveryanovV.TestBook.entities.Book;
import com.AveryanovV.TestBook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<BookInfoDTO> getBooksByGenreContaining(String genreKeyword) {
        return bookRepository.findBooksByGenreContaining("%" + genreKeyword + "%");
    }
}

