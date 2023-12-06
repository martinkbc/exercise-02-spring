package com.example.exercise02spring.persistance.repositories;

import com.example.exercise02spring.model.entities.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/BookRepositoryTest.sql")
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        List<Book> result = bookRepository.findAll();

        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(3);
    }

    @Test
    void insertBook() {
        bookRepository.insertBook(4L,"My book");
        List<Book> result = bookRepository.findAll();

        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(4);
    }
}