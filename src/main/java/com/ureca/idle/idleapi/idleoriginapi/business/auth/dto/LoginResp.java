package com.ureca.idle.idleapi.idleoriginapi.business.auth.dto;

import com.ureca.idle.idlejpa.user.User;


public record LoginResp (String email, String role) {
    public static LoginResp from(User user) {
        return new LoginResp(user.getEmail(), user.getRole().getValue());
    }
}
