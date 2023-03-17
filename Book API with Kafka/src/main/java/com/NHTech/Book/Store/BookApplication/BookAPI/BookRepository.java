package com.NHTech.Book.Store.BookApplication.BookAPI;

import com.NHTech.Book.Store.BookApplication.BookAPI.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
