package com.spring.RentABook.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.RentABook.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User,String>{
    public List<User> findAll();
}
