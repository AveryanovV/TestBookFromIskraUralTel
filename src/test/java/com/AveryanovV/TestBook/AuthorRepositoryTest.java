package com.AveryanovV.TestBook;
import com.AveryanovV.TestBook.entities.Author;
import com.AveryanovV.TestBook.repository.AuthorRepository;
import com.AveryanovV.TestBook.services.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthorRepositoryTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void testFindAuthorsWithTotalBooksAtLeast() {

        int minTotalCopies = 10;
        List<Object[]> authorsWithTotalBooks = new ArrayList<>();
        Author author1 = new Author(1L, "John", "Doe");
        Author author2 = new Author(2L, "Jane", "Smith");
        authorsWithTotalBooks.add(new Object[]{author1, 15L});
        authorsWithTotalBooks.add(new Object[]{author2, 20L});

        when(authorRepository.findAuthorsWithTotalBooksAtLeast(minTotalCopies)).thenReturn(authorsWithTotalBooks);

        List<Object[]> actualAuthorsWithTotalBooks = authorRepository.findAuthorsWithTotalBooksAtLeast(minTotalCopies);

        assertEquals(authorsWithTotalBooks.size(), actualAuthorsWithTotalBooks.size());

        for (int i = 0; i < actualAuthorsWithTotalBooks.size(); i++) {
            Object[] authorData = actualAuthorsWithTotalBooks.get(i);
            Author expectedAuthor = (Author) authorData[0];
            Long expectedTotal = (Long) authorData[1];

            assertEquals(authorsWithTotalBooks.get(i)[0], expectedAuthor);
            assertEquals(authorsWithTotalBooks.get(i)[1], expectedTotal);
        }
    }
}
