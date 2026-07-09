package org.example.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name="profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String bio;

    public Profile() {
    }

    public Profile(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {}
}
