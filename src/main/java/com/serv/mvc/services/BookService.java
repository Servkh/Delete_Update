package com.serv.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.serv.mvc.models.Book;
import com.serv.mvc.repositories.BookRepository;

@Service
public class BookService {
	 // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // delete a book
    public void deleteBook(Long id){
    	bookRepository.deleteById(id);
    }
    
    
    
    // updates a book
    public Book updateBook(Long id ,String title, String desc, String lang, int pages) {
    	Book updateBook  = bookRepository.getOne(id);
    	updateBook.setId(id);
    	updateBook.setTitle(title);
    	updateBook.setDescription(desc);
    	updateBook.setLanguage(lang);
    	updateBook.setNumberOfPages(pages);
    	return bookRepository.save(updateBook);
    }
}
