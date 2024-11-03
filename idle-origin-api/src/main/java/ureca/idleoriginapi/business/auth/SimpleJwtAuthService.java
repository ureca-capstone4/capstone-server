package ureca.idleoriginapi.business.auth;

import ureca.idlejpa.user.User;
import ureca.idleoriginapi.business.auth.dto.LoginReq;
import ureca.idleoriginapi.business.auth.dto.LoginResp;
import ureca.idleoriginapi.business.auth.dto.SignupReq;
import ureca.idleoriginapi.business.auth.dto.SignupResp;
import ureca.idleoriginapi.implementation.mapper.AuthDtoMapper;
import ureca.idleoriginapi.implementation.user.UserManager;
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
