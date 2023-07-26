package com.AveryanovV.TestBook.services;

import com.AveryanovV.TestBook.entities.Author;
import com.AveryanovV.TestBook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Object[]> getAuthorsWithTotalBooksAtLeast(int minTotalBooks) {
        return authorRepository.findAuthorsWithTotalBooksAtLeast(minTotalBooks);
    }
}