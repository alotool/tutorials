package io.github.alotool.tutorials.service;

import io.github.alotool.tutorials.dto.BookDto;
import io.github.alotool.tutorials.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<BookDto> getBooks() {
        return this.bookRepository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<BookDto> getBook(Long id) {
        return this.bookRepository.findById(id).map(BookDto::new);
    }

}
