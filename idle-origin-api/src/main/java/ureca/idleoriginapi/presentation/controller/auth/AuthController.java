package ureca.idleoriginapi.presentation.controller.auth;

import com.ureca.idle.originapi.business.auth.AuthUseCase;
import com.ureca.idle.originapi.business.auth.dto.LoginReq;
import com.ureca.idle.originapi.business.auth.dto.LoginResp;
import com.ureca.idle.originapi.business.auth.dto.SignupReq;
import com.ureca.idle.originapi.business.auth.dto.SignupResp;
import com.ureca.idle.originapi.presentation.web.jwt.JwtDto;
import com.ureca.idle.originapi.presentation.web.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/auth")
//@CrossOrigin("https://urecapstone.netlify.app")
@CrossOrigin(origins="http://localhost:1234")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginReq req) {
        LoginResp resp = authUseCase.login(req);
        String jwt = jwtProvider.create(resp.id(), resp.role());
        return ResponseEntity.ok(new JwtDto(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResp> signup(@RequestBody SignupReq req) {
        SignupResp resp = authUseCase.signup(req);
        return ResponseEntity.ok(resp);
    }
}
