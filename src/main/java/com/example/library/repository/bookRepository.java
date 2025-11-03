package com.example.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public interface bookRepository extends MongoRepository<Book, String> {

    // Find all books published in the given year
    List<Book> findByPublicationYear(int publicationYear);

    // Delete all books published in the given year and return number deleted
    long deleteByPublicationYear(int publicationYear);
}
