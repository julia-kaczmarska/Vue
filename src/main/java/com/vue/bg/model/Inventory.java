package com.vue.bg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String species;
    private Integer quantity;
    private String state;
    @Column(columnDefinition = "TEXT")
    private String notes;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastmod_time;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_place")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "id_source")
    private Source source;
}
