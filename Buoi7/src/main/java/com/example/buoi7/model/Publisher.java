package com.example.buoi7.model;

import com.example.buoi7.exception.InternalException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publishers")

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String founderYer;

    public Publisher(String name, String founderYer, Author author) {
        this.name = name;
        this.founderYer = founderYer;
        if(author.getPublisher() != null) {
            throw new InternalException("This author already has a publisher!");
        }
        this.author = author;
    }

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "author_id", unique = true)
    private Author author;

}
