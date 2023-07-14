package com.example.springjpaloggingerror;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SomeRepository extends JpaRepository<SomeEntity, Long> {

    @Query(value = """
            FROM SomeEntity e
            WHERE e.name like %?#{escape([0])}% escape ?#{escapeCharacter()}
            """)
    List<SomeEntity> findByQuery(String name);
}
