package com.ureca.idle.idleapi.idleoriginapi.presentaion.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.KidManagingUseCase;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetKidsDetailResp;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.GetKidsProfilesResp;
import com.ureca.idle.idleapi.web.auth.IdAndAuthority;
import com.ureca.idle.idleapi.web.auth.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kids")
@RequiredArgsConstructor
public class KidManagingController {

    private final KidManagingUseCase kidManagingUseCase;

    @PostMapping("")
    public ResponseEntity<AddKidResp> addMyKid(
            @LoginUser IdAndAuthority loginUser, @RequestBody AddKidReq req) {
        AddKidResp resp = kidManagingUseCase.addMyKid(loginUser.id(), req);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("")
    public ResponseEntity<GetKidsProfilesResp> getMyKidsProfiles(
            @LoginUser IdAndAuthority loginUser) {
        GetKidsProfilesResp resp = kidManagingUseCase.getMyKidsProfiles(loginUser.id());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{kidId}/detail")
    public ResponseEntity<GetKidsDetailResp> getMyKidsDetail(
            @LoginUser IdAndAuthority loginUser, @PathVariable Long kidId) {
        GetKidsDetailResp resp = kidManagingUseCase.getMyKidsDetail(loginUser.id(), kidId);
        return ResponseEntity.ok(resp);
    }
}
