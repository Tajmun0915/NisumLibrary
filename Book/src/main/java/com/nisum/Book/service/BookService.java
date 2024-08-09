package com.nisum.Book.service;

import com.nisum.Book.model.Book;
import com.nisum.Book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
     private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id , Book book){
        if(bookRepository.existsById(id)){
            book.setBookid(id);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBookById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            System.out.println("Book with " + id + "Does Not Exits");
        }
    }
}
