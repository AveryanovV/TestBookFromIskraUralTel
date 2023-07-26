package com.AveryanovV.TestBook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = {"id", "firstName", "lastName"})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {

    public Author(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    //считаем что у одной книги может быть только 1 автор и если автора удаляем то и все его книги тоже;-)
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true) // (просто для примера каскадов)
    private List<Book> books = new ArrayList<>();

}
