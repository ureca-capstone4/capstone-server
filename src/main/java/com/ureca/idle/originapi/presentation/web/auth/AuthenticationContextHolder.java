package com.ureca.idle.originapi.presentation.web.auth;


public class AuthenticationContextHolder {
    private static final ThreadLocal<IdAndAuthority> context = new ThreadLocal<>();

    private AuthenticationContextHolder() {}

    public static IdAndAuthority getContext() {
        return context.get();
    }

    public static void setContext(IdAndAuthority idAndAuthority) {
        context.set(idAndAuthority);
    }

    public static void clear() {
        context.remove();
    }
}

