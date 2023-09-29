package com.spring.RentABook.controllers;
import java.util.List;

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

import com.spring.RentABook.entity.Author;
@Validated
@RestController
@Tag(name = "Author")
public class author {
    @Autowired
    private authorServiceImpl authorService;

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable("id") String id){
        return authorService.getAuthorById(id);
    }
    @GetMapping("/author")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
    @PostMapping("/author")
    public ResponseEntity<Author> newAuthor(@jakarta.validation.Valid@RequestBody Author author){
        System.out.print(author);
        if(author.getId()!=null){
            return ResponseEntity.badRequest().build();
        }
        Author createdUser=authorService.createNewUser(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
