package com.ureca.idle.idleapi.idleoriginapi.business.auth.dto;

import com.ureca.idle.idlejpa.user.User;

public record SignupResp(String message) {
    public static SignupResp of(User registeredUser) {
        return new SignupResp("성공적으로 " + registeredUser.getEmail() + " 유저가 등록되었습니다.");
    }
}
