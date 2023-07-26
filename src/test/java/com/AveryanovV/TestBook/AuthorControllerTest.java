package com.AveryanovV.TestBook;

import com.AveryanovV.TestBook.controllers.AuthorController;
import com.AveryanovV.TestBook.dto.AuthorBookInfoDTO;
import com.AveryanovV.TestBook.dto.AuthorDTO;
import com.AveryanovV.TestBook.entities.Author;

import com.AveryanovV.TestBook.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class AuthorControllerTest {

    @Mock
    private AuthorService authorService;


    @InjectMocks
    private AuthorController authorController;

    @BeforeEach
    public void setUp() {
        authorService = mock(AuthorService.class);
        authorController = new AuthorController(authorService);
    }

    @Test
    public void testGetAllAuthors() {
        // Arrange
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1L, "John", "Doe"));
        authors.add(new Author(2L, "Jane", "Smith"));
        when(authorService.getAllAuthors()).thenReturn(authors);

        // Act
        ResponseEntity<List<AuthorDTO>> responseEntity = authorController.getAllAuthors();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(authors.size(), responseEntity.getBody().size());
    }

    @Test
    public void testGetAuthorById_ExistingAuthor() {
        // Arrange
        Long authorId = 1L;
        Author author = new Author(authorId, "John", "Doe");
        when(authorService.getAuthorById(authorId)).thenReturn(author);

        // Act
        ResponseEntity<AuthorDTO> responseEntity = authorController.getAuthorById(authorId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(author.getId(), responseEntity.getBody().getId());
        assertEquals(author.getFirstName(), responseEntity.getBody().getFirstName());
        assertEquals(author.getLastName(), responseEntity.getBody().getLastName());
    }

    @Test
    public void testGetAuthorById_NonExistingAuthor() {
        // Arrange
        Long nonExistingAuthorId = 100L;
        when(authorService.getAuthorById(nonExistingAuthorId)).thenReturn(null);

        // Act
        ResponseEntity<AuthorDTO> responseEntity = authorController.getAuthorById(nonExistingAuthorId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAuthorsWithTotalBooksAtLeast() {
        // Arrange
        int minTotalCopies = 10;
        List<Object[]> authorsWithTotalBooks = new ArrayList<>();
        Author author1 = new Author(1L, "John", "Doe");
        authorsWithTotalBooks.add(new Object[]{author1, 15L});
        when(authorService.getAuthorsWithTotalBooksAtLeast(minTotalCopies)).thenReturn(authorsWithTotalBooks);

        ResponseEntity<List<AuthorBookInfoDTO>> responseEntity = authorController.getAuthorsWithTotalBooksAtLeast(minTotalCopies);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(authorsWithTotalBooks.size(), responseEntity.getBody().size());

        AuthorBookInfoDTO expectedDTO = new AuthorBookInfoDTO();
        expectedDTO.setAuthorName(author1.getLastName() + " " + author1.getFirstName());
        expectedDTO.setTotalBooks(15);

        AuthorBookInfoDTO actualDTO = responseEntity.getBody().get(0);
        assertEquals(expectedDTO.getAuthorName(), actualDTO.getAuthorName());
        assertEquals(expectedDTO.getTotalBooks(), actualDTO.getTotalBooks());
    }


}
