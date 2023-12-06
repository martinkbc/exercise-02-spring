package com.example.exercise02spring.services;

import com.example.exercise02spring.model.entities.Book;
import com.example.exercise02spring.persistance.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }
}
