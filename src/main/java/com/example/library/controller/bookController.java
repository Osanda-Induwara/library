package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // 📚 Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 🔍 Get book by ID
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    // ✏️ Update book details
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // ❌ Delete book by ID
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

    // 📅 Find books by publication year
    @GetMapping("/year/{year}")
    public List<Book> findBooksByPublicationYear(@PathVariable int year) {
        return bookService.findBooksByPublicationYear(year);
    }

    // 🎭 Get genre by book ID
    @GetMapping("/{id}/genre")
    public String getGenreByBookId(@PathVariable String id) {
        return bookService.getGenreByBookId(id);
    }

    // 🗑️ Delete all books published in a specific year
    @DeleteMapping("/year/{year}")
    public void deleteBooksByPublicationYear(@PathVariable int year) {
        bookService.deleteBooksByPublicationYear(year);
    }
}
