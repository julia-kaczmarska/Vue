package com.vue.bg.controller;

import com.vue.bg.controller.dto.InventoryDto;
import com.vue.bg.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory")
    public List<InventoryDto> getInventory(@RequestParam(required = false) Integer page) {
        int pageNumber = (page != null && page >= 0) ? page : 0;
        return inventoryService.getInventory(pageNumber);
    }
}
