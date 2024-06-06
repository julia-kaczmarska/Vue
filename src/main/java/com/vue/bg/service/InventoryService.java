package com.vue.bg.service;

import com.vue.bg.controller.dto.InventoryDto;
import com.vue.bg.controller.dto.PaginationDto;
import com.vue.bg.controller.mapper.InventoryMapper;
import com.vue.bg.model.Inventory;
import com.vue.bg.model.Place;
import com.vue.bg.model.Source;
import com.vue.bg.model.User;
import com.vue.bg.repository.InventoryRepository;
import com.vue.bg.repository.PlaceRepository;
import com.vue.bg.repository.SourceRepository;
import com.vue.bg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final SourceRepository sourceRepository;

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

    @Transactional
    public void updateInventory(Integer id, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventory.setName(inventoryDto.getName());
        inventory.setSpecies(inventoryDto.getSpecies());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setState(inventoryDto.getState());
        inventory.setNotes(inventoryDto.getNotes());
        inventory.setLastmod_time(new Timestamp(System.currentTimeMillis()));

        Place place = placeRepository.findByName(inventoryDto.getPlace().getName())
                .orElseThrow(() -> new RuntimeException("Place not found"));
        inventory.setPlace(place);

        Source source = sourceRepository.findByName(inventoryDto.getSource().getName())
                .orElseThrow(() -> new RuntimeException("Source not found"));
        inventory.setSource(source);

        User user = userRepository.findByName(inventoryDto.getUser().getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        inventory.setUser(user);

        inventoryRepository.save(inventory);
    }
}
