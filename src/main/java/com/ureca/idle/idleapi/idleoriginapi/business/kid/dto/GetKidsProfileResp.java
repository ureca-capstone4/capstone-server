package com.ureca.idle.idleapi.idleoriginapi.business.kid.dto;

import com.ureca.idle.idlejpa.kid.Kid;

public record GetKidsProfileResp(Long id, String name, String profileImageUrl) {
    public static GetKidsProfileResp of(Kid kid) {
        return new GetKidsProfileResp(kid.getId(), kid.getName(), kid.getProfileImageUrl());
    }
}
