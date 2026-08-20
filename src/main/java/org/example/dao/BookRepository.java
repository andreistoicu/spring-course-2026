package org.example.dao;

import org.example.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleIgnoreCase(String title);
    List<Book> findAll();
    List<Book> findByCategoryId(Long category);
    List<Book> findByAuthorId(Long category);
}
