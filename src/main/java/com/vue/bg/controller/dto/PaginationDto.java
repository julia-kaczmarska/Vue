package com.vue.bg.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationDto {
    private long totalElements;
    private int totalPages;
    private int size;
    private int number;
}