package com.spring.RentABook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.RentABook.entity.Author;
@Repository
public interface AuthorRepository extends MongoRepository<Author,String>{

}