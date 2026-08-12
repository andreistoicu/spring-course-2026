package org.example.dao.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.validator.ValidateAuthor;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ValidateAuthor(message="Name of the author must have 2 word")
    private String name;

    private String country;

    @OneToOne(mappedBy="author")
    @JsonIgnore
    private Book book;

    public Author() {
    }

    public Author(Long id, String name, String country, Book book) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", book=" + book +
                '}';
    }
}
