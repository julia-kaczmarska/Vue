package com.vue.bg.controller.mapper;

import com.vue.bg.controller.dto.PlaceDto;
import com.vue.bg.model.Place;

public class PlaceMapper {

    public static PlaceDto mapToPlaceDto(Place place) {
        return PlaceDto.builder()
                .name(place.getName())
                .build();
    }
}
