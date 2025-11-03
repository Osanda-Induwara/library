package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    // ➕ Add new book
    @PostMapping
    @NonNull
    public ResponseEntity<Book> addBook(@RequestBody @NonNull Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // 📚 Get all books
    @GetMapping
    @NonNull
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 🔍 Get book by ID
    @GetMapping("/{id}")
@NonNull
public ResponseEntity<Book> getBookById(@PathVariable @NonNull String id) {
    Optional<Book> book = bookService.getBookById(id);
    return book.map(value -> ResponseEntity.ok().body(value))
               .orElseGet(() -> ResponseEntity.notFound().build());
}


    // ✏️ Update book details
    @PutMapping("/{id}")
    @NonNull
    public ResponseEntity<Book> updateBook(@PathVariable @NonNull String id, 
                                           @RequestBody @NonNull Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        }
        return ResponseEntity.notFound().build();
    }

    // ❌ Delete book by ID
    @DeleteMapping("/{id}")
    @NonNull
    public ResponseEntity<Void> deleteBookById(@PathVariable @NonNull String id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            bookService.deleteBookById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // 📅 Find books by publication year
    @GetMapping("/year/{year}")
    @NonNull
    public ResponseEntity<List<Book>> findBooksByPublicationYear(@PathVariable int year) {
        List<Book> books = bookService.findBooksByPublicationYear(year);
        return ResponseEntity.ok(books);
    }

    // 🎭 Get genre by book ID
    @GetMapping("/{id}/genre")
    @NonNull
    public ResponseEntity<String> getGenreByBookId(@PathVariable @NonNull String id) {
        String genre = bookService.getGenreByBookId(id);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        }
        return ResponseEntity.notFound().build();
    }

    // 🗑️ Delete all books published in a specific year
    @DeleteMapping("/year/{year}")
    @NonNull
    public ResponseEntity<Void> deleteBooksByPublicationYear(@PathVariable int year) {
        bookService.deleteBooksByPublicationYear(year);
        return ResponseEntity.noContent().build();
    }
}
