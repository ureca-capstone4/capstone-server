package com.ureca.idle.idleapi.idleoriginapi.business.kid.dto;

import com.ureca.idle.idlejpa.kid.Kid;

public record AddKidResp(String name) {
    public static AddKidResp of(Kid newKid) {
        return new AddKidResp("성공적으로 " + newKid.getName() + " 이(가) 등록되었습니다.");
    }
}
