package com.spring.RentABook.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RentABook.entity.Author;
import com.spring.RentABook.repository.AuthorRepository;
@Service
public class authorServiceImpl implements authorService{
    
    @Autowired
    private AuthorRepository authorRepository;
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    public Optional<Author> getAuthorByID(String id){
        Optional<Author> k=this.authorRepository.findById(id);
        System.out.println(k+" "+k.isPresent());
        return k;
    }

    public Author createAuthor(Author newAuthor){
        return this.authorRepository.insert(newAuthor);
    }

    public Boolean modifyAuthor(Author author){
        Optional<Author> toBeModAuthor=this.authorRepository.findById(author.getId());
        if(toBeModAuthor.isPresent()){
            this.authorRepository.save(author);
            return true;
        }
        return false;
    }
}
