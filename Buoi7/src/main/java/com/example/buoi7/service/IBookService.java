package com.example.buoi7.service;

import com.example.buoi7.dto.BookDTO;
import com.example.buoi7.model.Book;

import java.util.List;


public interface IBookService {
    Book createNewBook(BookDTO bookDTO);
    Book findBookById(int id);
    List<Book> findAllBook();
    Book updateBookById(int id,BookDTO bookDTO);
    Book deleteBookById(int id);
}
