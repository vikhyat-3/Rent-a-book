package com.spring.RentABook.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Validated
@Document(collection = "Book")
@Entity
public class Book {
    public Book(String id,
            @NotBlank(message = "Please enter book name") @NotNull(message = "Please enter book name") @Size(min = 2, max = 100) @Length(min = 2, max = 100) String name,
            Author author, Date publishedDate, ArrayList<Genre> genre, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;

    @NotBlank(message = "Please enter book name")
    @NotNull(message = "Please enter book name")
    @Size(min = 2, max = 100)
    @Length(min = 2, max = 100)
    private String name;

    private Author author;
    private Date publishedDate;
    private ArrayList<Genre> genre;
    private String description;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

}
