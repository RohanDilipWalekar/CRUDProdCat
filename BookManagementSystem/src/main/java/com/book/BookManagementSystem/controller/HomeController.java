package com.book.BookManagementSystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.BookManagementSystem.model.BookDesc;
import com.book.BookManagementSystem.repository.BookService;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";  // Ensure home.jsp exists in WEB-INF/jsp/
    }

    @RequestMapping(value = "/viewbook", method = RequestMethod.GET)
    public String viewBooks(Model model) {
        List<BookDesc> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "viewbooks";  // Ensure viewbooks.jsp exists in WEB-INF/jsp/
    }

    @RequestMapping(value = "/addbookss", method = RequestMethod.GET)
    public String addBookForm() {
        return "addbook";  // Ensure addbook.jsp exists in WEB-INF/jsp/
    }

    @RequestMapping(value = "/addingBook", method = RequestMethod.POST)
    public String addBooks(@RequestParam("BName") String BName,
                            @RequestParam("BAuthor") String BAuthor,
                            @RequestParam("BPublish") String BPublish,
                            @RequestParam("BPrice") int BPrice,
                            Map<String, String> map) {

        BookDesc newBook = new BookDesc();
        newBook.setBName(BName);
        newBook.setBAuthor(BAuthor);
        newBook.setBPublish(BPublish);
        newBook.setBPrice(BPrice);

        bookService.addBook(newBook);  // Adds the book using the service

        map.put("msg", "Book added successfully");  // Optional, you could also show this on the view

        return "redirect:/viewbook";  // Redirect to viewbooks page after adding a book
    }
    @RequestMapping(value = "/book/delete/{BId}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("BId") int BId) {
        bookService.deleteBook(BId);
        return "redirect:/viewbook"; 
    }
    @RequestMapping(value = "/book/update/{BId}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("BId") int BId, Model model) {
       
        model.addAttribute("BId", BId);  
        return "update"; 
    }

   
    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public String updateBook(@RequestParam("BId") int BId,
                             @RequestParam("bAuthor") String bAuthor,
                             @RequestParam("BPublisher") String BPublisher,
                             @RequestParam("BPrice") int BPrice) {
        bookService.updateBookById(BId, bAuthor, BPublisher, BPrice);
        return "redirect:/viewbook"; 
    }
}
