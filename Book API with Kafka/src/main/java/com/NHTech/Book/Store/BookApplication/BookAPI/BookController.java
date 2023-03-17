package com.NHTech.Book.Store.BookApplication.BookAPI;

import com.NHTech.Book.Store.KafkaSetting.KafkaBook;
import com.NHTech.Book.Store.KafkaSetting.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        kafkaProducer.sendBookMessage(new KafkaBook(book, "Post"));
        return bookService.save(book);
    }

    @PutMapping("/{isbn}")
    public Book updateBook(@PathVariable String isbn, @RequestBody Book book) {
        Book bookDB = bookService.findById(isbn);
        bookDB.setAuthor(book.getAuthor());
        bookDB.setTitle(book.getTitle());
        bookDB.setPrice(book.getPrice());
        bookService.save(bookDB);
        kafkaProducer.sendBookMessage(new KafkaBook(bookDB, "Update"));
        return bookDB;
    }

    @DeleteMapping("/{isbn}")
    public Book deleteBook(@PathVariable String isbn) {
        Book bookDB = bookService.findById(isbn);
        bookService.delete(bookDB);
        kafkaProducer.sendBookMessage(new KafkaBook(bookDB, "Delete"));
        return bookDB;
    }

    @GetMapping("/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return bookService.findById(isbn);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

}
