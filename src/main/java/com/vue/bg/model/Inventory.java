package com.vue.bg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String species;
    private Integer quantity;
    private String state;
    private String notes;
    private Timestamp lastmod_time;
    private Integer id_user;
    private Integer id_place;
    private Integer id_source;
}
