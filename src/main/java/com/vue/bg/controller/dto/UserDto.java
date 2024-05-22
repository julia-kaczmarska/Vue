package com.vue.bg.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {
    private String email;
    private String name;

    // Add new user
    @Getter
    @Builder
    public static class UserInfo implements Serializable {
        private String email;
        private String name;
        private String password;
    }

    // Get user data
    @Getter
    @Builder
    public static class UserDetailed implements Serializable {
        private String email;
        private String name;
        private String role;
    }
}