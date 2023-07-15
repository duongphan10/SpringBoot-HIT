package com.example.buoi7.service.imp;

import com.example.buoi7.dto.PublisherDTO;
import com.example.buoi7.exception.NotFoundException;
import com.example.buoi7.model.Author;
import com.example.buoi7.model.Publisher;
import com.example.buoi7.repo.AuthorRepository;
import com.example.buoi7.repo.PublisherRepository;
import com.example.buoi7.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPublisherService implements IPublisherService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Override
    public Publisher createNewPublisher(PublisherDTO publisherDTO) {
        Author author = authorRepository.findById(publisherDTO.getAuthor_id())
                .orElseThrow(()-> new NotFoundException("Không tồn tại author_id: " + publisherDTO.getAuthor_id()));
        return publisherRepository.save(new Publisher(publisherDTO.getName(),publisherDTO.getFounderYer(),author));
    }

    @Override
    public List<Publisher> findAllPublisher() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findPublisherByPageAndSize(int page, int size) {
        if (page<0) page = 0;
        return publisherRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending())).getContent();
    }

    @Override
    public Publisher updatePublisherById(int id,PublisherDTO publisherDTO) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tồn tại id: "+ id));
        Author author = authorRepository.findById(publisherDTO.getAuthor_id())
                .orElseThrow(()-> new NotFoundException("Không tồn tại author_id: "+ publisherDTO.getAuthor_id()));
        author.setPublisher(null);
        publisher.setName(publisherDTO.getName());
        publisher.setFounderYer(publisherDTO.getFounderYer());
        publisher.setAuthor(author);
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher deletePublisherById(int id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tồn tại id: "+ id));

        publisherRepository.delete(publisher);
        return publisher;
    }
}
