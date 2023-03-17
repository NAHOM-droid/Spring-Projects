package com.NHTech.Book.Store.BookApplication.BookAPI;

import com.NHTech.Book.Store.BookApplication.BookAPI.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(String isbn);

    void delete(Book bookDB);

    List<Book> findAll();
}
