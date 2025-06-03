package com.segundoparcial.pnc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segundoparcial.pnc.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
