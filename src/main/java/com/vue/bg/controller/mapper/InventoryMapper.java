package com.vue.bg.controller.mapper;

import com.vue.bg.controller.dto.InventoryDto;
import com.vue.bg.model.Inventory;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory) {
        return InventoryDto.builder()
                .id(inventory.getId())
                .name(inventory.getName())
                .species(inventory.getSpecies())
                .quantity(inventory.getQuantity())
                .state(inventory.getState())
                .notes(inventory.getNotes())
                .lastmod_time(inventory.getLastmod_time())
                .user(UserMapper.mapToUserDto(inventory.getUser()))
                .place(PlaceMapper.mapToPlaceDto(inventory.getPlace()))
                .source(SourceMapper.mapToSourceDto(inventory.getSource()))
                .build();
    }
}
