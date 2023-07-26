package com.AveryanovV.TestBook.repository;

import com.AveryanovV.TestBook.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // запрос для поиска информации о книгах авторов, у которых общее количество экземпляров книг не менее указанного значения
    @Query("SELECT a, SUM(b.count) " +
            "FROM Author a " +
            "JOIN a.books b " +
            "GROUP BY a " +
            "HAVING SUM(b.count) >= :minTotalCopies")
    List<Object[]> findAuthorsWithTotalBooksAtLeast(int minTotalCopies);

}
