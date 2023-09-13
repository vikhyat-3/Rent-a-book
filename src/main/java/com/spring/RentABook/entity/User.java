package com.spring.RentABook.entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

// @Entity
@Document(collection = "User")
public class User {

    @Id
    // @GeneratedValue
    private String id;
    
    private String name;
    public User(){}
    public User(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
