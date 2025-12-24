package yossefavr.demo.sakila.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Short languageId;

    @Column(name = "name")
    private String name;

    // =========================================
    // constructors
    // =========================================

    // empty constructor
    public Language() {
    }

    // buisness constructor
    public Language(Short languageId, String name) {
        this.languageId = languageId;
        this.name = name;

    }

    // =======================================
    // Getters and Setters
    // =======================================
    public Short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}