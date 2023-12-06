package com.example.exercise02spring.persistance.repositories;

import com.example.exercise02spring.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    @Transactional
    @Modifying
    @Query(value = "insert into book values (:id, :name)", nativeQuery = true)
    void insertBook(@Param("id") Long id,
                    @Param("name") String name);

}
