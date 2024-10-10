package cate_book.demo_crud_category_book.repository;

import cate_book.demo_crud_category_book.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByBookNameContainingIgnoreCase(String bookName);
}
