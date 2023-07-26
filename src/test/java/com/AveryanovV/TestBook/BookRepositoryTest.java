package com.AveryanovV.TestBook;
import com.AveryanovV.TestBook.dto.BookInfoDTO;
import com.AveryanovV.TestBook.repository.BookRepository;
import com.AveryanovV.TestBook.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindBooksByGenreContaining() {

        String genreKeyword = "Fantasy";
        List<BookInfoDTO> expectedBooksByGenre = new ArrayList<>();
        expectedBooksByGenre.add(new BookInfoDTO("Book1", "John Doe", "Fantasy"));
        expectedBooksByGenre.add(new BookInfoDTO("Book2", "Jane Smith", "Fantasy"));

        when(bookRepository.findBooksByGenreContaining(anyString())).thenReturn(expectedBooksByGenre);

        List<BookInfoDTO> actualBooksByGenre = bookService.getBooksByGenreContaining(genreKeyword);

        assertEquals(expectedBooksByGenre.size(), actualBooksByGenre.size());
        assertEquals(expectedBooksByGenre, actualBooksByGenre);
    }
}
