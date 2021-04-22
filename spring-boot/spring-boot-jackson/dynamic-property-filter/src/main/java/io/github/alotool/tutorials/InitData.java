package io.github.alotool.tutorials;

import io.github.alotool.tutorials.domain.Author;
import io.github.alotool.tutorials.domain.Book;
import io.github.alotool.tutorials.repository.AuthorRepository;
import io.github.alotool.tutorials.repository.BookRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class InitData implements ApplicationRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public InitData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(ApplicationArguments args) {

        // Create data in database for author.
        final Author tom = new Author();
        tom.setName("Tom");
        tom.setEmail("tom@gmail.com");
        tom.setGender("m");

        final Author jon = new Author();
        jon.setName("Jon");
        jon.setEmail("jon@gmail.com");
        jon.setGender("m");

        List<Author> authors = new ArrayList<>();
        authors.add(tom);
        authors.add(jon);

        authors = authorRepository.saveAll(authors);


        // Create data in database for book.
        Book book1 = new Book();
        book1.setName("Spring in Action");
        book1.setPrice(1000);
        book1.setQuantity(5000);
        book1.setAuthors(new HashSet<>(authors));

        Book book2 = new Book();
        book2.setName("Software Architecture with Spring 5.0");
        book2.setPrice(2000);
        book2.setQuantity(1000);
        book2.setAuthors(new HashSet<>(authors));

        bookRepository.save(book1);
        bookRepository.save(book2);

    }

}
