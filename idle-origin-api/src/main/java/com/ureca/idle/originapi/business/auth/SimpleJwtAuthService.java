package com.ureca.idle.originapi.business.auth;

import com.ureca.idle.originapi.business.auth.dto.LoginReq;
import com.ureca.idle.originapi.business.auth.dto.LoginResp;
import com.ureca.idle.originapi.business.auth.dto.SignupReq;
import com.ureca.idle.originapi.business.auth.dto.SignupResp;
import com.ureca.idle.originapi.implementation.mapper.AuthDtoMapper;
import com.ureca.idle.jpa.user.User;
import com.ureca.idle.originapi.implementation.user.UserManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleJwtAuthService implements AuthUseCase {

    private final UserManager userManager;
    private final AuthDtoMapper authDtoMapper;

    @Override
    public LoginResp login(LoginReq req) {
        User loginUser = userManager.getUserByEmailAndPassword(req.email(), req.password());
        return authDtoMapper.toLoginResp(loginUser);
    }

    @Override
    public void logout() {

    }

    @Override
    @Transactional
    public SignupResp signup(SignupReq req) {
        userManager.checkExistsUserByEmail(req.email());
        User registeredUser = userManager.registerUser(req.email(), req.password(), req.name(), req.phoneNum());
        return authDtoMapper.toSignupResp(registeredUser);
    }

    @Override
    public void withdraw() {

    }
}
