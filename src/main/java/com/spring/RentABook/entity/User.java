package com.spring.RentABook.entity;
import javax.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
// @Entity
@Validated
@Document(collection = "User")
public class User {

    @Id
    // @GeneratedValue
    private String id;
    @NotBlank(message = "Please enter user name")
    @NotNull(message = "Please enter user name but null raising")
    @Size(min = 2, max = 100)
    @Length(min = 2, max = 100)
    private String name;
    @Override
    public String toString(){
        return this.id+" "+this.name;
    }
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
