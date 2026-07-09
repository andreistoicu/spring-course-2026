package org.example.dao.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String title;

    @ManyToMany(mappedBy="courses")
    private Set<Student> students = new HashSet<Student>();
}
