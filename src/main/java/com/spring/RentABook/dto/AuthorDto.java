package com.spring.RentABook.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
@Document
@AllArgsConstructor
public class AuthorDto {
    private String id;
    public String getId() {
        return id;
    }
    @Schema(accessMode = AccessMode.READ_ONLY)
    private String name;
    public String getName() {
        return name;
    }
}
