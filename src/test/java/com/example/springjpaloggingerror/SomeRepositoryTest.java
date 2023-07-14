package com.example.springjpaloggingerror;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SomeRepositoryTest {

    @Autowired
    private SomeRepository repository;

    @Test
    void escapeTest() {
        // given
        repository.save(new SomeEntity(1L, "some company"));
        repository.save(new SomeEntity(2L, "some_company"));
        repository.save(new SomeEntity(3L, "some%company"));

        // expect
        assertEquals(1, repository.findByQuery("some company").size());
        assertEquals(1, repository.findByQuery("some_company").size());
        assertEquals(1, repository.findByQuery("some%company").size());
    }

}