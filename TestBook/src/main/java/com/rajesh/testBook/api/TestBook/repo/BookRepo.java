package com.rajesh.testBook.api.TestBook.repo;

import com.rajesh.testBook.api.TestBook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookRepo extends JpaRepository<Book, Integer> {


}
