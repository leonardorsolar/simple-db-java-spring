package br.com.aes.simpledb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aes.simpledb.entities.Book;
import br.com.aes.simpledb.repositories.BookRepository;

@RestController
@RequestMapping(value = "/book")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  // @GetMapping("getAll")
  // public List<Book> getData() {
  // return bookRepository.findAll();
  // }

  @GetMapping
  public List<Book> findAll() {
    List<Book> result = bookRepository.findAll();
    return result;
  }

}

// https://pt.linkedin.com/pulse/spring-boot-e-data-conex%C3%A3o-ao-banco-de-dados-denis-cabral-lopes