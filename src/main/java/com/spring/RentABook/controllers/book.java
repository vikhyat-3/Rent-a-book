package com.spring.RentABook.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.RentABook.service.bookServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.spring.RentABook.entity.Book;
@Validated
@RestController
@Tag(name = "Books")
public class book {
    
    @Autowired
    private bookServiceImpl bookService;

    
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks(){
        try{
            List<Book> listOfBooks=this.bookService.getBooks();
            System.out.println(listOfBooks);
            return ResponseEntity.status(HttpStatus.OK).body(listOfBooks);
            
            // return ResponseEntity.badRequest().build();

        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createNewBook(@jakarta.validation.Valid@RequestBody Book newBook){
        System.out.println(newBook+" "+newBook.getId());
        if(newBook.getId()==null){
            try{

                Book newBookCreated= this.bookService.createBook(newBook);
                return ResponseEntity.status(HttpStatus.CREATED).body(newBookCreated);
            }
            catch(Exception e){
                System.out.println("TRYING TO CATCH");
                return ResponseEntity.badRequest().build();
            }
        }
        else{
            System.out.println("BAD REQUEST INCOMING");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/bookByID/{id}")
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable("id") String bookID){
        try{
            Optional<Book> fetchedBook=this.bookService.getBookByID(bookID);
            if(fetchedBook.isPresent())
                return ResponseEntity.status(HttpStatus.OK).body(fetchedBook);
            else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }   
}
