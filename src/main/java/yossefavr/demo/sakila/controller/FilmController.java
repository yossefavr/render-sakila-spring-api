package yossefavr.demo.sakila.controller;

import yossefavr.demo.sakila.dto.FilmDTO;
import yossefavr.demo.sakila.repositories.FilmRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmRepository filmRepo;

    // Dependency Injection דרך Constructor (הדרך המומלצת!)
    public FilmController(FilmRepository filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping
    public List<FilmDTO> getAllFilms() {
        // שליפת ה-Entities והפיכתם ל-DTOs
        return filmRepo.findAll().stream()
                .map(f -> new FilmDTO(
                        f.getId(),
                        f.getTitle(),
                        f.getDescription(),
                        f.getLanguage().getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/search/{lang}")
    public List<FilmDTO> getFilmsByLanguage(@PathVariable String lang) {
        return filmRepo.findByLanguageName(lang).stream()
                .map(f -> new FilmDTO(
                        f.getId(),
                        f.getTitle(),
                        f.getDescription(),
                        f.getLanguage().getName()))
                .collect(Collectors.toList());
    }
}