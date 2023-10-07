package com.spring.RentABook.service;
import java.util.List;
import java.util.Optional;
import com.spring.RentABook.entity.Author;
public abstract interface authorService {
    public List<Author> getAllAuthors();

    public Optional<Author> getAuthorByID(String id);

    public Author createAuthor(Author newAuthor);

}
