package com.example.buoi7.service.imp;

import com.example.buoi7.dto.AuthorDTO;
import com.example.buoi7.model.Author;
import com.example.buoi7.repo.AuthorRepository;
import com.example.buoi7.service.IAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpAuthorService implements IAuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Author createNewAuthor(AuthorDTO authorDTO) {
        return authorRepository.save(new Author(authorDTO.getName(),authorDTO.getAddress()));
    }

    @Override
    public List<Author> listAuthors(int page, int size) {
        if (page < 0) page = 0;
        return authorRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending())).getContent();
    }
}
