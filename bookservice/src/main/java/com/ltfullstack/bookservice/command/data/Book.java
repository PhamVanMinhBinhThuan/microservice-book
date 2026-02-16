package com.ltfullstack.bookservice.command.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
public class Book {
    @Id
    private String id;

    private String name;
    private String author;
    private Boolean isReady;
}
