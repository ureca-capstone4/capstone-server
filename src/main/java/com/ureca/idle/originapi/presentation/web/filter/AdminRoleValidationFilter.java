package com.ureca.idle.originapi.presentation.web.filter;

import com.ureca.idle.originapi.presentation.web.auth.AuthenticationContextHolder;
import com.ureca.idle.originapi.presentation.web.auth.IdAndAuthority;
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
public class AdminRoleValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        IdAndAuthority idAndAuthority = AuthenticationContextHolder.getContext();
        if (!idAndAuthority.role().equals("role")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Admin 권한 유저만 접근할 수 있습니다.");
        }
        filterChain.doFilter(request, response);
    }
}
