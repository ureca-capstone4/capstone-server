package com.ureca.idle.originapi.implementation.mapper;

import com.ureca.idle.originapi.business.auth.dto.LoginResp;
import com.ureca.idle.originapi.business.auth.dto.SignupResp;
import com.ureca.idle.jpa.user.User;
import org.springframework.stereotype.Component;

@Component
public class AuthDtoMapper {

    public LoginResp toLoginResp(User loginUser) {
        return new LoginResp(loginUser.getId(), loginUser.getRole().getValue());
    }

    public SignupResp toSignupResp(User registeredUser) {
        return new SignupResp("성공적으로 " + registeredUser.getEmail() + " 유저가 등록되었습니다.");
    }
}
