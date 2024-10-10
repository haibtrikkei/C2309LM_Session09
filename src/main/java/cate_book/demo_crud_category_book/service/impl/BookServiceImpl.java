package cate_book.demo_crud_category_book.service.impl;

import cate_book.demo_crud_category_book.model.entity.Book;
import cate_book.demo_crud_category_book.repository.BookRepository;
import cate_book.demo_crud_category_book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer bookId) {
        return bookRepository.findById(bookId).orElseThrow(()->new NoSuchElementException("Khong ton tai book voi id: "+bookId));
    }

    @Override
    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer bookId, Book book) {
        bookRepository.findById(bookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai book void id: "+bookId));
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        try{
            bookRepository.deleteById(bookId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<Book> findByName(String bookName) {
        return bookRepository.findBooksByBookNameContainingIgnoreCase(bookName);
    }
}
