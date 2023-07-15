package com.example.buoi7.service.imp;

import com.example.buoi7.dto.BookDTO;
import com.example.buoi7.exception.NotFoundException;
import com.example.buoi7.model.Author;
import com.example.buoi7.model.Book;
import com.example.buoi7.repo.AuthorRepository;
import com.example.buoi7.repo.BookRepository;
import com.example.buoi7.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpBookService implements IBookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createNewBook(BookDTO bookDTO) {
        Optional<Author> author = authorRepository.findById(bookDTO.getAuthor_id());
        if (author.isEmpty()) {
            throw new NotFoundException("Không tồn tại author_id: " + bookDTO.getAuthor_id());
        }
        return bookRepository.save(new Book(bookDTO.getNameBook(), bookDTO.getDetail(), author.get()));
    }

    @Override
    public Book findBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException("Không tồn tại id:" + id);
        }
        return book.get();
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBookById(int id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tồn tại id: " + id));
        Author author = authorRepository.findById(bookDTO.getAuthor_id()).orElseThrow(() -> new NotFoundException("Không tồn tại author_id: " + bookDTO.getAuthor_id()));
        book.setNameBook(bookDTO.getNameBook());
        book.setDetail(bookDTO.getDetail());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book deleteBookById(int id) {
        //Book book = bookRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tồn tại id: " + id));
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException("Không tồn tại id: " + id);
        }
        bookRepository.deleteById(id);
        return book.get();
    }
}
