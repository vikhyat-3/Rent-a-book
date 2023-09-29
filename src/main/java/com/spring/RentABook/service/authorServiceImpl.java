package com.spring.RentABook.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RentABook.entity.Author;
import com.spring.RentABook.repository.AuthorRepository;

@Service
public class authorServiceImpl implements authorService{
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author createNewUser(Author author){
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(String id){
    	Author p=authorRepository.findById(id).get();
        return p;
    }
}
