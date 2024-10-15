package com.ureca.idle.inbound.auth;

import com.ureca.idle.application.auth.AuthUseCase;
import com.ureca.idle.application.auth.dto.LoginReq;
import com.ureca.idle.application.auth.dto.LoginResp;
import com.ureca.idle.application.auth.dto.SignupReq;
import com.ureca.idle.application.auth.dto.SignupResp;
import com.ureca.idle.inbound.jwt.JwtDto;
import com.ureca.idle.inbound.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginReq req) {
        LoginResp resp = authUseCase.getUserForLogin(req);
        String jwt = jwtProvider.create(resp.email(), resp.role());
        return ResponseEntity.ok(new JwtDto(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResp> signup(@RequestBody SignupReq req) {
        SignupResp resp = authUseCase.signup(req);
        return ResponseEntity.ok(resp);
    }
}
