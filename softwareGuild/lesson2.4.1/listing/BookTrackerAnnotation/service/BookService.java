package com.sg.booktrackerannotation.service;

import com.sg.booktrackerannotation.dao.BookDao;
import com.sg.booktrackerannotation.dto.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    
    private BookDao dao;

    @Autowired
    public BookService(BookDao dao) {
        this.dao = dao;
    }
    
    public Book getBookByTitle(String title) {
        return dao.getBookByTitle(title);
    }
    
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }
    
    public Book addBook(Book book) {
        return dao.addBook(book);
    }
    
    public void updateBook(Book book) {
        dao.updateBook(book);
    }
    
    public void deleteBookByTitle(String title) {
        dao.deleteBookByTitle(title);
    }
}
