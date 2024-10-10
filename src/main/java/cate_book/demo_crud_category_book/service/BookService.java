package cate_book.demo_crud_category_book.service;

import cate_book.demo_crud_category_book.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Integer bookId);
    Book insertBook(Book book);
    Book updateBook(Integer bookId, Book book);
    boolean deleteBook(Integer bookId);
    List<Book> findByName(String bookName);
}
