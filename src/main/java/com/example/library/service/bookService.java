package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.model.Book;

public interface bookService {

    // Method to add a new book
    Book addBook(Book book);

    //retrieve all books
    List<Book> getAllBooks();

    //fetch a book by id
    Optional<Book> getBookById(String id);

    //update book details
    Optional<Book> updateBook(String id, Book updatedBook);

    //delete a book by id
    void deleteBookById(String id);
     
    //find book by year
    List<Book> findBooksByPublicationYear(int year);

    //get genre by id
    Optional<String> getGenreByBookId(String id);

    //delete all books by year
    long deleteBooksByPublicationYear(int year);


}
