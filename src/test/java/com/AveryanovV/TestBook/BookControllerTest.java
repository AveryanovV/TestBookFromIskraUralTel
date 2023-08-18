package com.AveryanovV.TestBook;

import com.AveryanovV.TestBook.controllers.BookController;
import com.AveryanovV.TestBook.dto.BookDTO;
import com.AveryanovV.TestBook.dto.BookInfoDTO;
import com.AveryanovV.TestBook.entities.Book;
import com.AveryanovV.TestBook.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBooksByGenreContaining() {

        String genreKeyword = "Fantasy";
        List<BookInfoDTO> expectedBooksByGenre = new ArrayList<>();
        expectedBooksByGenre.add(new BookInfoDTO("Book1", "John Doe", "Fantasy"));
        expectedBooksByGenre.add(new BookInfoDTO("Book2", "Jane Smith", "Fantasy"));

        when(bookService.getBooksByGenreContaining(genreKeyword)).thenReturn(expectedBooksByGenre);

        ResponseEntity<List<BookInfoDTO>> responseEntity = bookController.getBooksByGenreContaining(genreKeyword);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBooksByGenre.size(), responseEntity.getBody().size());

        for (int i = 0; i < expectedBooksByGenre.size(); i++) {
            BookInfoDTO expectedBook = expectedBooksByGenre.get(i);
            BookInfoDTO actualBook = responseEntity.getBody().get(i);

            assertEquals(expectedBook.getBookName(), actualBook.getBookName());
            assertEquals(expectedBook.getAuthorName(), actualBook.getAuthorName());
            assertEquals(expectedBook.getGenreName(), actualBook.getGenreName());
        }

        verify(bookService, times(1)).getBooksByGenreContaining(genreKeyword);
        verifyNoMoreInteractions(bookService);
    }

    @Test
    public void testCreateBook() {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setNameBook("Book1");
        bookDTO.setYear(2023);

        Book newBook = convertToEntity(bookDTO);

        when(bookService.saveBook(newBook)).thenReturn(newBook);

        ResponseEntity<BookDTO> responseEntity = bookController.createBook(bookDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        BookDTO savedBookDTO = responseEntity.getBody();
        assertEquals(bookDTO.getNameBook(), savedBookDTO.getNameBook());
        assertEquals(bookDTO.getYear(), savedBookDTO.getYear());

        verify(bookService, times(1)).saveBook(newBook);
        verifyNoMoreInteractions(bookService);
    }


    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setNameBook(bookDTO.getNameBook());
        book.setYear(bookDTO.getYear());

        return book;
    }
}
