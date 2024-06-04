package com.cursesalura.challengeliterature.repository;

import com.cursesalura.challengeliterature.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT a FROM Book b JOIN b.authors a")
    List<Author> getAuthors ();

    @Query("SELECT a FROM Book b JOIN b.authors a WHERE birthYear > :date")
    List<Author> getAuthorLiveAfter ( Integer date );

    List<Book> findByLanguages(Languages languages);
}
