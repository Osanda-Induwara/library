package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    @NonNull
    Book addBook(@NonNull Book book);

    @NonNull
    List<Book> getAllBooks();

    @NonNull
    Optional<Book> getBookById(@NonNull String id);

    @Nullable
    Book updateBook(@NonNull String id, @NonNull Book bookDetails);

    void deleteBookById(@NonNull String id);

    @NonNull
    List<Book> findBooksByPublicationYear(int year);

    @Nullable
    String getGenreByBookId(@NonNull String id);

    void deleteBooksByPublicationYear(int year);
}
