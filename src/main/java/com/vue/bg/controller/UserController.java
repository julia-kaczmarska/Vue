package com.vue.bg.controller;

import com.vue.bg.controller.dto.UserDto;
import com.vue.bg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{name}")
    @PreAuthorize("#name == authentication.principal.username or hasAuthority('ADMIN')")
    public List<UserDto.UserDetailed> getUser(@PathVariable String name) {
        return userService.getUser(name);
    }
}