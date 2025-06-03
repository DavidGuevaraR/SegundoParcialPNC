package com.segundoparcial.pnc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 3, max = 100, message = "El título del libro debe tener entre 3 y 100 caracteres")
    @Pattern(regexp = ".*[a-zA-Z].*", message = "El título del libro no puede estar compuesto solo por números")
    private String title;

    @Column
    @Size(min = 3, max = 50, message = "El nombre del autor debe tener entre 3 y 50 caracteres")
    private String author;

    @Column(unique = true)
    @Size(min = 17, max = 17, message = "El ISBN debe tener exactamente 17 caracteres")
    private String isbn;

    @Min(value = 1900, message = "El año de publicación debe ser mayor a 1900")
    @Max(value = 2025, message = "El año de publicación no puede ser mayor a 2025")
    private Integer publicationYear;

    @Column(nullable = true)
    @Size(min = 3, max = 50, message = "El idioma debe tener entre 3 y 50 caracteres")
    private String language;

    @Min(value = 10, message = "El número de páginas debe ser al menos 10")
    @Max(value = 10000, message = "El número de páginas no puede ser mayor a 10000")
    private Integer pages;

    @Size(min = 3, max = 50, message = "El género debe tener entre 3 y 50 caracteres")
    private String genre;
}