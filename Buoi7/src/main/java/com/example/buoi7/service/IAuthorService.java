package com.example.buoi7.service;

import com.example.buoi7.dto.AuthorDTO;
import com.example.buoi7.model.Author;

import java.util.List;

public interface IAuthorService {
    Author createNewAuthor(AuthorDTO authorDTO);
    List<Author> listAuthors(int page, int size);
}
