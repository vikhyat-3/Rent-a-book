package com.spring.RentABook.config;

import org.springframework.stereotype.Component;

@Component
public interface Exceptions {
    public String NO_AUTHOR_FOUND="No author found";
    public String NO_BOOK_FOUND="No book found";
    public String NO_USER_FOUND="No user found";
    public String NO_SUCH_GENRE="Genre does not exist"; 
}
