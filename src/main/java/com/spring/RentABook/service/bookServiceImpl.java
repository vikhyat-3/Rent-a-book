package com.spring.RentABook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RentABook.entity.Book;
import com.spring.RentABook.repository.BookRepository;


@Service
public class bookServiceImpl implements bookService{
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getBooks(){
        return this.bookRepository.findAll();
    }

    public Book createBook(Book newBook){
        return this.bookRepository.insert(newBook);
    }

    public Optional<Book> getBookByID(String id){
        return this.bookRepository.findById(id);
    }
}
