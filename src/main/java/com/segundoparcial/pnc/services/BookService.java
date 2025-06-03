package com.segundoparcial.pnc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segundoparcial.pnc.entities.Book;
import com.segundoparcial.pnc.repositories.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(String author, String language, String genre, Integer minPages, Integer maxPages) {
        return bookRepository.findAll().stream()
                .filter(b -> author == null || b.getAuthor().equalsIgnoreCase(author))
                .filter(b -> language == null || b.getLanguage().equalsIgnoreCase(language))
                .filter(b -> genre == null || b.getGenre().equalsIgnoreCase(genre))
                .filter(b -> minPages == null || b.getPages() >= minPages)
                .filter(b -> maxPages == null || b.getPages() <= maxPages)
                .toList();
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findAll().stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, String newTitle, String newLanguage) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID: " + id));

        if (newTitle != null)
            book.setTitle(newTitle);
        if (newLanguage != null)
            book.setLanguage(newLanguage);

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
