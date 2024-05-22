package com.vue.bg.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "place")
    private Set<Inventory> inventory;
}
