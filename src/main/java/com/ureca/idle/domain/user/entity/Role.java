package com.ureca.idle.domain.user.entity;

import com.ureca.idle.domain.user.exception.UserNotFoundException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Role {
    USER("user"),
    ADMIN("admin");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static Role from(String role) {
        return Arrays.stream(Role.values())
                .filter(it -> it.value.equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("해당 유저의 역할을 찾을 수 없습니다."));
    }
}
