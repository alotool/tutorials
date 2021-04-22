package io.github.alotool.tutorials.web;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.github.alotool.tutorials.dto.BookDto;
import io.github.alotool.tutorials.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookRestApi {

    private final BookService bookService;

    public BookRestApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<MappingJacksonValue> getBooks() {

        final SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("bookFilter", SimpleBeanPropertyFilter.serializeAllExcept("quantity"));
        filterProvider.addFilter("authorFilter", SimpleBeanPropertyFilter.serializeAllExcept("gender"));

        final List<BookDto> books = this.bookService.getBooks();

        final MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(books);
        mappingJacksonValue.setFilters(filterProvider);

        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<MappingJacksonValue> getBook(@PathVariable("id") Long id) {

        final Optional<BookDto> book = bookService.getBook(id);
        if (book.isPresent()) {

            final SimpleFilterProvider filterProvider = new SimpleFilterProvider();
            filterProvider.addFilter("bookFilter", SimpleBeanPropertyFilter.serializeAllExcept("quantity"));
            filterProvider.addFilter("authorFilter", SimpleBeanPropertyFilter.serializeAllExcept("gender"));

            final MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(book.get());
            mappingJacksonValue.setFilters(filterProvider);

            return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
