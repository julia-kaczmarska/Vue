package com.vue.bg.repository;

import com.vue.bg.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    Optional<Place> findByName(String name);
}
