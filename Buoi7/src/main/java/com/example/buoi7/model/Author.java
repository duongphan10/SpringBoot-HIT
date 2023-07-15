package com.example.buoi7.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    public  Author(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @JsonManagedReference
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;

    @JsonManagedReference
    @OneToOne(mappedBy = "author", fetch = FetchType.EAGER)
    private Publisher publisher;
}
