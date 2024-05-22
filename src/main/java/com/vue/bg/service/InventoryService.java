package com.vue.bg.service;

import com.vue.bg.controller.dto.InventoryDto;
import com.vue.bg.controller.mapper.InventoryMapper;
import com.vue.bg.model.Inventory;
import com.vue.bg.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private static final int PAGE_SIZE = 3;
    private final InventoryRepository inventoryRepository;

    public List<InventoryDto> getInventory(int page) {
        List<Inventory> inventories = inventoryRepository.findAll(PageRequest.of(page, PAGE_SIZE)).getContent();
        return inventories.stream()
                .map(InventoryMapper::mapToInventoryDto)
                .collect(Collectors.toList());
    }
}