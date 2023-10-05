package com.spring.RentABook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.RentABook.entity.Book;
@Repository
public interface BookRepository extends MongoRepository<Book,String>{

}