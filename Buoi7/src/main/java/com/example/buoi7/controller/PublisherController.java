package com.example.buoi7.controller;

import com.example.buoi7.dto.PublisherDTO;
import com.example.buoi7.service.IAuthorService;
import com.example.buoi7.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
    @Autowired
    private IPublisherService iPublisherService;
    @PostMapping("/create_publisher")
    public ResponseEntity<?> createNewPublisher(@RequestBody PublisherDTO publisherDTO) {
        return ResponseEntity.ok().body(iPublisherService.createNewPublisher(publisherDTO));
    }
    @GetMapping("/find_all_publisher")
    public ResponseEntity<?> findAllPublisher() {
        return ResponseEntity.ok().body(iPublisherService.findAllPublisher());
    }
    @GetMapping("/find_list_publisher")
    public ResponseEntity<?> findPublisher(@RequestParam(name = "page") int page,
                                           @RequestParam(name = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok().body(iPublisherService.findPublisherByPageAndSize(page,size));
    }
    @PutMapping("/update_by_id/{id}")
    public ResponseEntity<?> updatePublisherById(@PathVariable("id") int id,
                                                 @RequestBody PublisherDTO publisherDTO) {
        return ResponseEntity.ok().body(iPublisherService.updatePublisherById(id,publisherDTO));
    }
    @DeleteMapping("/delete_by_id/{id}")
    public ResponseEntity<?> deletePublisherById(@PathVariable int id) {
        return ResponseEntity.ok().body(iPublisherService.deletePublisherById(id));
    }
}
