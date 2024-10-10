package cate_book.demo_crud_category_book.service;

import cate_book.demo_crud_category_book.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
