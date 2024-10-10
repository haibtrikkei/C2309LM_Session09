package cate_book.demo_crud_category_book.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "year_publish")
    private Integer yearPublish;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    private Category cate;
}
