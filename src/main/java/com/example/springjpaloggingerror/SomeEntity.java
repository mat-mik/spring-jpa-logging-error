package com.example.springjpaloggingerror;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SomeEntity {

    @Id
    private Long id;

    private String name;

    protected SomeEntity() {
        // jpa
    }

    public SomeEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
