package com.vue.bg.service;

import com.vue.bg.controller.dto.InventoryDto;
import com.vue.bg.controller.dto.PaginationDto;
import com.vue.bg.controller.mapper.InventoryMapper;
import com.vue.bg.model.Inventory;
import com.vue.bg.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public Map<String, Object> getInventory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Inventory> inventoryPage = inventoryRepository.findAll(pageable);

        List<InventoryDto> inventoryDtos = inventoryPage.getContent().stream()
                .map(InventoryMapper::mapToInventoryDto)
                .collect(Collectors.toList());

        long totalElements = inventoryPage.getTotalElements();
        int totalPages = inventoryPage.getTotalPages();

        PaginationDto pagination = new PaginationDto(totalElements, totalPages, size, page + 1);

        Map<String, Object> response = new HashMap<>();
        response.put("pagination", pagination);
        response.put("content", inventoryDtos);

        return response;
    }
}
