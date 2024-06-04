package com.vue.bg.repository;

import com.vue.bg.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @EntityGraph(attributePaths = {"user", "place", "source"})
    Page<Inventory> findAll(Pageable pageable);
}