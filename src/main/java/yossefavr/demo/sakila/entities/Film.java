package yossefavr.demo.sakila.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    // =========================================
    // constructors
    // =========================================

    // empty constructor (required by JPA)
    public Film() {
    }

    // buisness constructor (description excluded for brevity)
    public Film(Integer id, String title, String description, Language language, List<Actor> actors,
            List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.language = language;
        this.actors = actors;
        this.categories = categories;
    }

    // ========================================
    // Getters & Setters
    // ========================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }
}