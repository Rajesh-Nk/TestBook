package com.rajesh.testBook.api.TestBook.services;

import com.rajesh.testBook.api.TestBook.entities.Book;
import com.rajesh.testBook.api.TestBook.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book b){
        Book book= bookRepo.save(b);
        return book;
    }
    public List<Book> getAllBook(){
        List<Book> book=bookRepo.findAll();
        return book;
    }

    public Optional<Book> bookById(int id){
        return bookRepo.findById(id);
    }

    public void deleteBook(){
        bookRepo.deleteAll();
    }

    //Method for deleting book by id
    public void deleteBookByID(int id){
        bookRepo.deleteById(id);
    }

}
