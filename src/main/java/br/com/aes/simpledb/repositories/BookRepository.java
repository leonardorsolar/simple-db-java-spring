package br.com.aes.simpledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aes.simpledb.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
