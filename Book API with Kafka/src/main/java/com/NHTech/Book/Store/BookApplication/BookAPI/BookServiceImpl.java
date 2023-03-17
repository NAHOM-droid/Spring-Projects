package com.NHTech.Book.Store.BookApplication.BookAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(String isbn) {
        return bookRepository.findById(isbn).get();
    }

    @Override
    public void delete(Book bookDB) {
        bookRepository.delete(bookDB);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
