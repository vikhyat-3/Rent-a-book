package com.spring.RentABook.service;

import java.util.List;

import com.spring.RentABook.entity.Book;

public abstract interface bookService {
    public List<Book> getBooks();

    public Book createBook(Book newBook);
}
