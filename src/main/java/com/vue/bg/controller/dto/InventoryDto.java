package com.vue.bg.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class InventoryDto implements Serializable {
    private Integer id;
    private String name;
    private String species;
    private Integer quantity;
    private String state;
    private String notes;
    private Timestamp lastmod_time;
    private UserDto user;
    private PlaceDto place;
    private SourceDto source;
}