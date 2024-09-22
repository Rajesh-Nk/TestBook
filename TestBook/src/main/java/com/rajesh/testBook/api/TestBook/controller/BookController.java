package com.rajesh.testBook.api.TestBook.controller;

import com.rajesh.testBook.api.TestBook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rajesh.testBook.api.TestBook.entities.Book;

import java.util.List;
import java.util.Optional;


@RestController("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //add Book
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    // Get all the books
    @GetMapping("/allBook")
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    //get books by id
    @GetMapping("/book/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        return bookService.bookById(id);
    }

    //Delete all book
    @DeleteMapping("/deleteBook")
    public void deleteBook(){
        bookService.deleteBook();
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable int id){
        bookService.deleteBookByID(id);
    }


}
