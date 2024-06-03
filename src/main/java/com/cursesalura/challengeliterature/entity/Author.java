package com.cursesalura.challengeliterature.entity;

import com.cursesalura.challengeliterature.model.AuthorDto;
import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer birthYear;
    private Integer deathYear;
    private String name;

    @ManyToOne
    private Book book;

    public Author( Author author) {
    }

    public Author(String name, Integer birthYear, Integer deathYear, Book book) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }
    public Book getBook () {
        return book;
    }

    public void setBook ( Book book ) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author : " + name + '\n' +
                "Birth Year: " + birthYear + '\n' +
                "Death Year: " + deathYear + '\n';
    }
}
