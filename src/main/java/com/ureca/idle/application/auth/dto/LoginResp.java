package com.ureca.idle.application.auth.dto;

import com.ureca.idle.domain.user.entity.User;


public record LoginResp (String email, String role) {
    public static LoginResp from(User user) {
        return new LoginResp(user.getEmail(), user.getRole().getValue());
    }
}
