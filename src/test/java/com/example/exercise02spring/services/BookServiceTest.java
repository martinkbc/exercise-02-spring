package com.example.exercise02spring.services;

import com.example.exercise02spring.model.entities.Book;
import com.example.exercise02spring.persistance.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void list() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(0L,"name1"));
        books.add(new Book(1L,"name2"));

        when(bookRepository.findAll()).thenReturn(books);

        assertThat(bookService.list()).size().isEqualTo(2);
    }
}