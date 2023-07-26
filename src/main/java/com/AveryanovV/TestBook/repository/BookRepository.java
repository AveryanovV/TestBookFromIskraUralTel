package com.AveryanovV.TestBook.repository;

import com.AveryanovV.TestBook.dto.BookInfoDTO;
import com.AveryanovV.TestBook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //Запрос для поиска информации о книгах (книга, автор, жанр), относящихся к жанру, включающему слово из параметра запроса в отсортированном по названиям книг виде.
    @Query("SELECT new com.AveryanovV.TestBook.dto.BookInfoDTO(b.nameBook, CONCAT(a.lastName, ' ', a.firstName), g.name) " +
            "FROM Book b " +
            "JOIN b.author a " +
            "JOIN b.genres g " +
            "WHERE g.name LIKE %:genreKeyword% " +
            "ORDER BY b.nameBook")
    List<BookInfoDTO> findBooksByGenreContaining(String genreKeyword);

}
