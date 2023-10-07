package com.spring.RentABook.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.RentABook.service.authorServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import com.spring.RentABook.entity.Author;
@Validated
@RestController
@Tag(name = "Author")
public class author {

    @Autowired
    private authorServiceImpl authorServiceImpl;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        try{
            List<Author> allAuthors=this.authorServiceImpl.getAllAuthors();
            return ResponseEntity.status(HttpStatus.OK).body(allAuthors);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("author")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author newAuthor){
        try{
            return ResponseEntity.status((HttpStatus.CREATED)).body(this.authorServiceImpl.createAuthor(newAuthor));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorByID(@PathVariable("id") String authorID){
        try{
            Optional<Author> retrievedAuthor=this.authorServiceImpl.getAuthorByID(authorID);
            if(retrievedAuthor.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(retrievedAuthor.get());
            else return ResponseEntity.notFound().build();
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    
}
