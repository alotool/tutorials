package io.github.alotool.tutorials.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.github.alotool.tutorials.domain.Book;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "price", "quantity"})

// Jackson annotations
@JsonFilter("bookFilter")
public class BookDto {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private Set<AuthorDto> authors = new HashSet<>();

    public BookDto(Book book) {
        if (book != null) {
            this.setId(book.getId());
            this.setName(book.getName());
            this.setPrice(book.getPrice());
            this.setQuantity(book.getQuantity());
            final Set<AuthorDto> authors = book.getAuthors().stream().map(AuthorDto::new).collect(Collectors.toSet());
            this.setAuthors(authors);
        }
    }

}
