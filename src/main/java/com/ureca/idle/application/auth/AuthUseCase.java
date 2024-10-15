package com.ureca.idle.application.auth;

import com.ureca.idle.application.auth.dto.LoginReq;
import com.ureca.idle.application.auth.dto.LoginResp;
import com.ureca.idle.application.auth.dto.SignupReq;
import com.ureca.idle.application.auth.dto.SignupResp;

public interface AuthUseCase {
    LoginResp getUserForLogin(LoginReq req);
    void logout();
    SignupResp signup(SignupReq req);
    void withdraw();
}
