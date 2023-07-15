package com.example.buoi7.controller;

import com.example.buoi7.dto.BookDTO;
import com.example.buoi7.service.IAuthorService;
import com.example.buoi7.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @PostMapping("/create_book")
    public ResponseEntity<?> createNewBook(@ModelAttribute BookDTO bookDTO) {
        return ResponseEntity.ok().body(iBookService.createNewBook(bookDTO));
    }

    @GetMapping("/find_by_id/{id}")
    public ResponseEntity<?> findBookById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(iBookService.findBookById(id));
    }
    @GetMapping("/find_all")
    public ResponseEntity<?> findAllBook() {
        return ResponseEntity.ok().body(iBookService.findAllBook());
    }
    @PutMapping("/update_by_id/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable int id,@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(iBookService.updateBookById(id,bookDTO));
    }
    @DeleteMapping("/delete_by_id/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable int id) {
        return ResponseEntity.ok().body(iBookService.deleteBookById(id));
    }
}
