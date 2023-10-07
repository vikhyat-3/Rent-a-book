package com.spring.RentABook.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.RentABook.dto.AuthorDto;
import com.spring.RentABook.entity.Author;
import com.spring.RentABook.entity.Book;
import com.spring.RentABook.repository.BookRepository;
import jakarta.xml.ws.http.HTTPException;

@Service
public class bookServiceImpl extends RuntimeException implements bookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private authorServiceImpl authorService;
    public List<Book> getBooks(){
        return this.bookRepository.findAll();
    }

    public Book createBook(Book newBook){
        String authorID=newBook.getAuthor().getId();
        Optional<Author> correspondingAuthor=this.authorService.getAuthorByID(authorID);
        try{

        if(correspondingAuthor.isPresent()){
            
            //first insert the book, to ensure DBRef does not give error
            Book newlyCreatedBook=this.bookRepository.insert(newBook);

            //Get the author, and add the book to his list of book which is stored in the Database as DBRefs.
            Author correspondingAuthorEntity=correspondingAuthor.get();
            correspondingAuthorEntity.getBooks().add(newlyCreatedBook);
            boolean flag=this.authorService.modifyAuthor(correspondingAuthorEntity);
            if(flag==false)
                throw new HTTPException(404);
            
            //Now add author details to the book via the AuthorDTO to prevent circular referencing
            AuthorDto correspondingAuthorDto=new AuthorDto(correspondingAuthorEntity.getId(), correspondingAuthorEntity.getName());
            newlyCreatedBook.setAuthor(correspondingAuthorDto);
            this.bookRepository.save(newlyCreatedBook);
            return newlyCreatedBook;
        }
        else{
            throw new HTTPException(404);
        }
        }
        catch(Exception e){
            System.out.println(e);
            throw new HTTPException(404);
        }
    }
    
    public Optional<Book> getBookByID(String id){
        return this.bookRepository.findById(id);
    }
}
