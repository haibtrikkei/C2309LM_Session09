package cate_book.demo_crud_category_book.service.impl;

import cate_book.demo_crud_category_book.model.entity.Category;
import cate_book.demo_crud_category_book.repository.CategoryRepository;
import cate_book.demo_crud_category_book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
