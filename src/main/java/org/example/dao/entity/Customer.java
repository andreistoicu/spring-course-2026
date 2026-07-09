package org.example.dao.entity;

import jakarta.persistence.*;

@Entity //mandatory pentru creare tabel
@Table(name="customer") // optional doar pentru a crea un tabel cu nume diferit de numela clasei -> Customer
public class Customer {

    @Id //primary key mandatory
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // este recomandat sa utilizam aceasta adnotare insa nu oblogatoriu
    // daca numele campului este identic cu coloana din DB
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Embedded
    private Address address;

    @Transient // nu merge in baza de date
    private String CNP;

    @Version
    private Long version;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", CNP='" + CNP + '\'' +
                ", version=" + version +
                '}';
    }
}
