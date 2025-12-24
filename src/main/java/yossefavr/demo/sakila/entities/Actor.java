package yossefavr.demo.sakila.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    // ========================================
    // constructors
    // ========================================

    // empty constructor (required by JPA)
    public Actor() {
    }

    // buisness constructor
    public Actor(Integer id, String firstName, String lastName, List<Film> films) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.films = films;
    }

    // =========================================
    // Getters & Setters
    // =========================================

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
