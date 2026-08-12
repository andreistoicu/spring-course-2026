package org.example.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(name="title")
    @NotBlank(message="Title must not be blank")
    @Size(min=1, max=30, message="Title length must be between 1 and 3 chars")
    private String title;

    @DecimalMax(value="1000.0", message="price must be lower than 1000 EUR")
    @Column(name="price", nullable=false)
    private Double price;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private Author author;

    @OneToMany(mappedBy="book", cascade=CascadeType.ALL,
            fetch=FetchType.EAGER,
            orphanRemoval=true)
    private List<Chapter> chapter;

    public Book() {
    }

    public Book(Long id, Long version, String title, Double price, Author author, List<Chapter> chapter) {
        this.id = id;
        this.version = version;
        this.title = title;
        this.price = price;
        this.author = author;
        this.chapter = chapter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author=" + author +
                ", chapter=" + chapter +
                '}';
    }
}
