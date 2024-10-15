package com.ureca.idle.application.auth;

import com.ureca.idle.application.auth.dto.LoginReq;
import com.ureca.idle.application.auth.dto.LoginResp;
import com.ureca.idle.application.auth.dto.SignupReq;
import com.ureca.idle.application.auth.dto.SignupResp;
import com.ureca.idle.domain.user.entity.User;
import com.ureca.idle.domain.user.manager.UserManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserManager userManager;

    @Override
    public LoginResp getUserForLogin(LoginReq req) {
        return LoginResp.from(userManager.getUserByEmailAndPassword(req.email(), req.password()));
    }

    @Override
    public void logout() {

    }

    @Override
    @Transactional
    public SignupResp signup(SignupReq req) {
        userManager.checkExitsUserByEmail(req.email());
        User registeredUser = userManager.registerUser(req.email(), req.password());
        return SignupResp.of(registeredUser);
    }

    @Override
    public void withdraw() {

    }
}
