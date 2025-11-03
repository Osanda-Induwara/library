package com.example.library.repository;

import com.example.library.model.Book;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository <Book, String> {

    // Custom query methods
    List<Book> findByPublicationYear(int publicationYear);
}
