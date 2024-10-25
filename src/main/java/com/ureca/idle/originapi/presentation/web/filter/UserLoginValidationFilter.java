package com.ureca.idle.originapi.presentation.web.filter;

import com.ureca.idle.originapi.presentation.web.auth.AuthenticationContextHolder;
import com.ureca.idle.originapi.presentation.web.auth.IdAndAuthority;
import com.ureca.idle.originapi.presentation.web.jwt.JwtException;
import com.ureca.idle.originapi.presentation.web.jwt.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class UserLoginValidationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);
        if (token == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "토큰이 없습니다. 로그인 후 토큰을 발급받아 다시 요청해주세요.");
            return;
        }
        try {
            IdAndAuthority idAndAuthority = jwtProvider.extract(token);
            AuthenticationContextHolder.setContext(idAndAuthority);
        } catch (JwtException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage() + " 로그인 후 토큰을 발급받아 다시 요청해주세요.");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
