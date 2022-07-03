package edu.miu.bookapplication.services;

import edu.miu.bookapplication.domain.Book;

import java.util.List;

public interface bookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
    Book getBook(String iSBN);
    List<Book> getAllBooks();
}
