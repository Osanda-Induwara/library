package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(String id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setPublicationYear(bookDetails.getPublicationYear());
            book.setShelfLocation(bookDetails.getShelfLocation());
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByPublicationYear(int year) {
        return bookRepository.findByPublicationYear(year);
    }

    @Override
    public String getGenreByBookId(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(Book::getGenre).orElse(null);
    }

    @Override
    public void deleteBooksByPublicationYear(int year) {
        List<Book> books = bookRepository.findByPublicationYear(year);
        bookRepository.deleteAll(books);
    }
}
