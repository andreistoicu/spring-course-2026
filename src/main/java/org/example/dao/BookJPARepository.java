package org.example.dao;

import org.example.dao.entity.Author;
import org.example.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJPARepository extends JpaRepository<Book, Long> {

    //putem utiliza un Query in baza de date atunci cand
    //metodele din JPA nu exista, si avem un query mai complex
    /*
    @Modifying
    @Query("UPDATE Book b SET b.title=:title, b.price=:price, b.author=:author WHERE b.id=:id")
    void updateBookById(Long id, Double price, String title, Author author);*/

}
