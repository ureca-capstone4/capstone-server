package ureca.idleoriginapi.business.auth;


import ureca.idleoriginapi.business.auth.dto.LoginReq;
import ureca.idleoriginapi.business.auth.dto.LoginResp;
import ureca.idleoriginapi.business.auth.dto.SignupReq;
import ureca.idleoriginapi.business.auth.dto.SignupResp;


public interface AuthUseCase {
    LoginResp login(LoginReq req);
    void logout();
    SignupResp signup(SignupReq req);
    void withdraw();
}
