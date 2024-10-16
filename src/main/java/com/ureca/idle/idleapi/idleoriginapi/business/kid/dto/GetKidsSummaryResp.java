package com.ureca.idle.idleapi.idleoriginapi.business.kid.dto;

import com.ureca.idle.idlejpa.kid.Kid;

public record GetKidsSummaryResp(Long id, String name, String profileImageUrl) {
    public static GetKidsSummaryResp of(Kid kid) {
        return new GetKidsSummaryResp(kid.getId(), kid.getName(), kid.getProfileImageUrl());
    }
}
