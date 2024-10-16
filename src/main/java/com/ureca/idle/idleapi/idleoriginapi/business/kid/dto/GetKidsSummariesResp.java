package com.ureca.idle.idleapi.idleoriginapi.business.kid.dto;

import com.ureca.idle.idlejpa.kid.Kid;

import java.util.List;

public record GetKidsSummariesResp(List<GetKidsSummaryResp> kidsSummaries) {
    public static GetKidsSummariesResp of(List<Kid> kids) {
        return new GetKidsSummariesResp(
                kids.stream()
                .map(GetKidsSummaryResp::of)
                .toList()
        );
    }
}
