package com.vue.bg.controller.mapper;

import com.vue.bg.controller.dto.UserDto;
import com.vue.bg.model.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
