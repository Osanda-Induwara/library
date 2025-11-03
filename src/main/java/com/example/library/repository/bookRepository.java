package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    // Custom query methods
    @NonNull
    List<Book> findByPublicationYear(int publicationYear);
    
    // Override methods from MongoRepository with @NonNull annotations
    @Override
    @NonNull
    <S extends Book> S save(@NonNull S entity);
    
    @Override
    @NonNull
    Optional<Book> findById(@NonNull String id);
    
    @Override
    @NonNull
    List<Book> findAll();
}
