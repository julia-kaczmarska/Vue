package com.vue.bg.controller;

import com.vue.bg.controller.dto.InventoryDto;
import com.vue.bg.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory")
    public ResponseEntity<Map<String, Object>> getInventory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        Map<String, Object> response = inventoryService.getInventory(page, size);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/inventory/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateInventory(@PathVariable Integer id, @RequestBody InventoryDto inventoryDto) {
        inventoryService.updateInventory(id, inventoryDto);
    }
}