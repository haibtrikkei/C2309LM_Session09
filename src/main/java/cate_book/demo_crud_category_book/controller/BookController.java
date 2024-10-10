package cate_book.demo_crud_category_book.controller;

import cate_book.demo_crud_category_book.model.entity.Book;
import cate_book.demo_crud_category_book.model.entity.Category;
import cate_book.demo_crud_category_book.repository.BookRepository;
import cate_book.demo_crud_category_book.service.BookService;
import cate_book.demo_crud_category_book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String listBooks(Model model){
        List<Book> list = bookService.findAll();
        model.addAttribute("list",list);
        return "book/listBook";
    }

    @GetMapping("/initInsertBook")
    public String initInsertBook(Model model){
        List<Category> listCate = categoryService.findAll();
        Book b = new Book();

        model.addAttribute("listCate",listCate);
        model.addAttribute("b",b);

        return "book/insertBook";
    }

    @PostMapping("/insertBook")
    public String insertBook(@ModelAttribute("b")Book b, Model model){
        Book book = bookService.insertBook(b);
        if(book!=null){
            return "redirect:/books";
        }else{
            model.addAttribute("error","Insert failed!");
            List<Category> listCate = categoryService.findAll();

            model.addAttribute("listCate",listCate);
            model.addAttribute("b",b);

            return "book/insertBook";
        }
    }

    @GetMapping("/detailBook")
    public String detailBook(@RequestParam("bookId")Integer bookId, Model model){
        Book book = bookService.findById(bookId);
        model.addAttribute("b",book);
        return "book/detailBook";
    }

    @GetMapping("/preUpdateBook")
    public String preUpdateBook(@RequestParam("bookId")Integer bookId, Model model){
        Book book = bookService.findById(bookId);
        model.addAttribute("b",book);

        List<Category> listCate = categoryService.findAll();
        model.addAttribute("listCate",listCate);

        return "book/updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("b")Book b, Model model){
        Book book = bookService.updateBook(b.getBookId(), b);
        if(book!=null){
            return "redirect:/books";
        }else{
            model.addAttribute("error","Update failed!");
            List<Category> listCate = categoryService.findAll();

            model.addAttribute("listCate",listCate);
            model.addAttribute("b",b);

            return "book/updateBook";
        }
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId")Integer bookId, Model model){
        boolean bl = bookService.deleteBook(bookId);
        return "redirect:/books";
    }

    @GetMapping("/searchBooks")
    public String searchBooks(@RequestParam(name = "bookName", defaultValue = "")String bookName, Model model){
        List<Book> list = bookService.findByName(bookName);
        model.addAttribute("list",list);
        return "book/listBook";
    }
}
