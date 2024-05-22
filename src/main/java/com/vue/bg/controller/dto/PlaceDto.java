package com.vue.bg.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class PlaceDto implements Serializable {
    private String name;
}
