package com.vue.bg.service;

import com.vue.bg.controller.dto.UserDto;
import com.vue.bg.model.User;
import com.vue.bg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto.UserDetailed> getUser(String name) {
        Optional<User> users = userRepository.findByName(name);
        return users.stream()
                .map(user -> UserDto.UserDetailed.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .role(user.getRole())
                        .build())
                .collect(Collectors.toList());
    }
}
