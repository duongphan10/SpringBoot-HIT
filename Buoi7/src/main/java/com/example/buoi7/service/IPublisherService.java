package com.example.buoi7.service;

import com.example.buoi7.dto.PublisherDTO;
import com.example.buoi7.model.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher createNewPublisher(PublisherDTO publisherDTO);
    List<Publisher> findAllPublisher();
    List<Publisher> findPublisherByPageAndSize(int page,int size);
    Publisher updatePublisherById(int id, PublisherDTO publisherDTO);
    Publisher deletePublisherById(int id);
}
