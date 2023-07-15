package com.example.buoi7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameStore;
    private String address;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "store_books", //Tên của bảng
                joinColumns = @JoinColumn(name = "store_id"),
                inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}
