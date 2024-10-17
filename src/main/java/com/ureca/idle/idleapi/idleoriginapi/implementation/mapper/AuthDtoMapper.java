package com.ureca.idle.idleapi.idleoriginapi.implementation.mapper;

import com.ureca.idle.idleapi.idleoriginapi.business.auth.dto.LoginResp;
import com.ureca.idle.idleapi.idleoriginapi.business.auth.dto.SignupResp;
import com.ureca.idle.idlejpa.user.User;
import org.springframework.stereotype.Component;

@Component
public class AuthDtoMapper {

    public LoginResp toLoginResp(User user) {
        return new LoginResp(user.getEmail(), user.getRole().getValue());
    }

    public SignupResp toSignupResp(User registeredUser) {
        return new SignupResp("성공적으로 " + registeredUser.getEmail() + " 유저가 등록되었습니다.");
    }
}
