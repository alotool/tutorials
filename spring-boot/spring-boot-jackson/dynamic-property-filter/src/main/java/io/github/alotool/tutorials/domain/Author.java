package io.github.alotool.tutorials.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "email", "gender"})

// Persistence annotations
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "gender", length = 1)
    private String gender; // Value ('m' or 'f')

}
