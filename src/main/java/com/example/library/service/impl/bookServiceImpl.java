package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @NonNull
    public Book addBook(@NonNull Book book) {
        return bookRepository.save(book);
    }

    @Override
    @NonNull
    public List<Book> getAllBooks() {
        // Ensure we never return null, even if no books found
        List<Book> books = bookRepository.findAll();
        return books != null ? books : List.of();
    }

    @Override
    @NonNull
    public Optional<Book> getBookById(@NonNull String id) {
        return bookRepository.findById(id);
    }

    @Nullable
    @Override
    public Book updateBook(@NonNull String id, @NonNull Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            // Safely update fields, handling potential null values
            String title = bookDetails.getTitle();
            if (title != null) {
                book.setTitle(title);
            }
            
            String author = bookDetails.getAuthor();
            if (author != null) {
                book.setAuthor(author);
            }
            
            String genre = bookDetails.getGenre();
            if (genre != null) {
                book.setGenre(genre);
            }
            
            book.setPublicationYear(bookDetails.getPublicationYear());
            
            String shelfLocation = bookDetails.getShelfLocation();
            if (shelfLocation != null) {
                book.setShelfLocation(shelfLocation);
            }
            
            return bookRepository.save(book);
        }
        // Return null if book not found (marked @Nullable)
        return null;
    }

    @Override
    public void deleteBookById(@NonNull String id) {
        bookRepository.deleteById(id);
    }

    @Override
    @NonNull
    public List<Book> findBooksByPublicationYear(int year) {
        List<Book> books = bookRepository.findByPublicationYear(year);
        return books != null ? books : List.of();
    }

    @Nullable
    @Override
    public String getGenreByBookId(@NonNull String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(Book::getGenre).orElse(null);
    }

    @Override
    public void deleteBooksByPublicationYear(int year) {
        List<Book> books = bookRepository.findByPublicationYear(year);
        if (books != null && !books.isEmpty()) {
            bookRepository.deleteAll(books);
        }
    }
}
