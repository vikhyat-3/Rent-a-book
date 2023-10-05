package com.spring.RentABook.service;

import java.util.List;
import java.util.Optional;

import com.spring.RentABook.entity.Book;

public abstract interface bookService {
    public List<Book> getBooks();

    public Book createBook(Book newBook);

    public Optional<Book> getBookByID(String id); 
}
