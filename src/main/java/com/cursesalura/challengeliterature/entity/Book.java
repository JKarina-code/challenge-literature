package com.cursesalura.challengeliterature.entity;

import jakarta.persistence.*;

import java.util.*;

import com.cursesalura.challengeliterature.model.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;

    @Enumerated(EnumType.STRING)
    private Languages languages;
    private Double downloads;

    public Book() {
    }

    public Book(List<BookDto> results) {
    }

    public Book(String title, List<String> languages, Double downloads, List<AuthorDto> authors) {
        this.title = title;
        this.languages = Languages.fromString(languages.get(0));
        this.downloads = downloads;
        this.authors = new ArrayList<>();
        for (AuthorDto authorInfo : authors) {
            Author author = new Author(authorInfo.name(), authorInfo.birthYear(), authorInfo.deathYear(), this);
            this.authors.add(author);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        authors.forEach(e -> e.setBook(this));
        this.authors = authors;
    }


    @Override
    public String toString() {
        return "------ Book ------"
                + "\n" + "Títle: " + title + "\n"
                + "Author: " + authors + "\n" + "Languages=" + languages + "\n"
                + "Downloads Number: " + downloads + "\n" + "-------------------";
    }
}
