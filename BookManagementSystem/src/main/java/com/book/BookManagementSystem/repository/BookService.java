package com.book.BookManagementSystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.BookManagementSystem.model.BookDesc;
import com.book.BookManagementSystem.service.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	public List<BookDesc> getAllBooks() {
		
		return bookRepo.getAllBooks();
	}
	public void addBook(BookDesc newBook) {
		// TODO Auto-generated method stub
		bookRepo.addBook(newBook);
	}
	public void deleteBook(int BId) {
		bookRepo.deleteBookById(BId);
    }
	public void updateBookById(int BId, String bAuthor, String BPublisher, int BPrice) {
        bookRepo.updateBookById(BId, bAuthor, BPublisher, BPrice);
    }
}
