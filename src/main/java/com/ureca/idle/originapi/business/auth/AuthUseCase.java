package com.ureca.idle.originapi.business.auth;

import com.ureca.idle.originapi.business.auth.dto.LoginResp;
import com.ureca.idle.originapi.business.auth.dto.SignupResp;
import com.ureca.idle.originapi.business.auth.dto.LoginReq;
import com.ureca.idle.originapi.business.auth.dto.SignupReq;

public interface AuthUseCase {
    LoginResp login(LoginReq req);
    void logout();
    SignupResp signup(SignupReq req);
    void withdraw();
}
