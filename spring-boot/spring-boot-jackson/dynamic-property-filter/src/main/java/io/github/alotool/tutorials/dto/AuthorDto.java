package io.github.alotool.tutorials.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.github.alotool.tutorials.domain.Author;
import lombok.*;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "email", "gender"})

// Jackson annotations
@JsonFilter("authorFilter")
public class AuthorDto {

    private Long id;
    private String name;
    private String email;
    private String gender; // Value ('m' or 'f')

    public AuthorDto(Author author) {
        if (author != null) {
            this.setId(author.getId());
            this.setName(author.getName());
            this.setEmail(author.getEmail());
            this.setGender(author.getGender());
        }
    }
}
