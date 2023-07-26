package com.AveryanovV.TestBook.controllers;

import com.AveryanovV.TestBook.dto.GenreDTO;
import com.AveryanovV.TestBook.entities.Genre;
import com.AveryanovV.TestBook.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<Genre> genres = genreService.getAllGenres();
        List<GenreDTO> genreDTOs = genres.stream()
                .map(GenreDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(genreDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id) {
        Genre genre = genreService.getGenreById(id);
        if (genre != null) {
            GenreDTO genreDTO = new GenreDTO(genre);
            return new ResponseEntity<>(genreDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genreDTO) {
        Genre genre = convertToEntity(genreDTO);
        Genre savedGenre = genreService.saveGenre(genre);
        GenreDTO savedGenreDTO = new GenreDTO(savedGenre);
        return new ResponseEntity<>(savedGenreDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Long id, @RequestBody GenreDTO genreDTO) {
        Genre existingGenre = genreService.getGenreById(id);
        if (existingGenre != null) {
            Genre updatedGenre = convertToEntity(genreDTO);
            updatedGenre.setId(id);
            Genre savedGenre = genreService.saveGenre(updatedGenre);
            GenreDTO savedGenreDTO = new GenreDTO(savedGenre);
            return new ResponseEntity<>(savedGenreDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenreById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Genre convertToEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        return genre;
    }
}


