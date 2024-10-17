package com.ureca.idle.idleapi.idleoriginapi.business.auth;

import com.ureca.idle.idleapi.idleoriginapi.business.auth.dto.LoginReq;
import com.ureca.idle.idleapi.idleoriginapi.business.auth.dto.LoginResp;
import com.ureca.idle.idleapi.idleoriginapi.business.auth.dto.SignupReq;
import com.ureca.idle.idleapi.idleoriginapi.business.auth.dto.SignupResp;
import com.ureca.idle.idlejpa.user.User;
import com.ureca.idle.idleapi.idleoriginapi.implementation.user.UserManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleJwtAuthService implements AuthUseCase {

    private final UserManager userManager;

    @Override
    public LoginResp login(LoginReq req) {
        return LoginResp.from(userManager.getUserByEmailAndPassword(req.email(), req.password()));
    }

    @Override
    public void logout() {

    }

    @Override
    @Transactional
    public SignupResp signup(SignupReq req) {
        userManager.checkExitsUserByEmail(req.email());
        User registeredUser = userManager.registerUser(req.email(), req.password(), req.name(), req.phoneNum());
        return SignupResp.of(registeredUser);
    }

    @Override
    public void withdraw() {

    }
}
