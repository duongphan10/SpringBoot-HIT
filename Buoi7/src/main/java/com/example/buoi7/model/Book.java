package com.example.buoi7.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBook;
    private String detail;
    public Book(String nameBook, String detail, Author author) {
        this.nameBook = nameBook;
        this.detail = detail;
        this.author = author;
    }
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Store> stores;

}
