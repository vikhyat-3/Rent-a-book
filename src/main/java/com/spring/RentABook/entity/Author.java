package com.spring.RentABook.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Validated
@Document(collection = "Author")
@Entity
public class Author {
    @Id
    @GeneratedValue
    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;

    @NotBlank(message = "Please enter author name")
    @NotNull(message = "Please enter author name")
    @Size(min = 2, max = 100)
    @Length(min = 2, max = 100)
    private String name;

    private Gender gender;

    @DBRef
    @Schema(accessMode = AccessMode.READ_ONLY)
    private ArrayList<Book> books;

    public Author(String id,
            @NotBlank(message = "Please enter author name") @NotNull(message = "Please enter author name") @Size(min = 2, max = 100) @Length(min = 2, max = 100) String name,
            Gender gender, ArrayList<Book> books) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        if(books==null)
        this.books = new ArrayList<>();
        else this.books=books;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }


}
