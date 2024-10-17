package com.ureca.idle.idleapi.idleoriginapi.business.kid.dto;

import com.ureca.idle.idlejpa.kid.Kid;

import java.util.List;

public record GetKidsProfilesResp(List<GetKidsProfileResp> kidsSummaries) {
    public static GetKidsProfilesResp of(List<Kid> kids) {
        return new GetKidsProfilesResp(
                kids.stream()
                .map(GetKidsProfileResp::of)
                .toList()
        );
    }
}
