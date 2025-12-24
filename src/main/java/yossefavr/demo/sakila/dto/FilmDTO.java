package yossefavr.demo.sakila.dto;

public record FilmDTO(
        Integer id,
        String title,
        String description,
        String languageName) {
}
