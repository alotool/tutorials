package io.github.alotool.tutorials.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "price", "quantity"})

// Persistence annotations
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    @BatchSize(size = 20)
    private Set<Author> authors = new HashSet<>();

}
