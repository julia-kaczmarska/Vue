package com.vue.bg.repository;

import com.vue.bg.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SourceRepository extends JpaRepository<Source, Integer> {
    Optional<Source> findByName(String name);
}
