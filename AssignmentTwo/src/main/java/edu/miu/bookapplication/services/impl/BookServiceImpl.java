package edu.miu.bookapplication.services.impl;

import edu.miu.bookapplication.domain.Book;
import edu.miu.bookapplication.services.bookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements bookService {

    @Override public void addBook(Book book) {

    }

    @Override public void updateBook(Book book) {

    }

    @Override public void deleteBook(Book book) {

    }

    @Override public Book getBook(String iSBN) {
        return null;
    }

    @Override public List<Book> getAllBooks() {
        return null;
    }
}
