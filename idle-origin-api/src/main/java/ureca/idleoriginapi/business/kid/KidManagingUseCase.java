package ureca.idleoriginapi.business.kid;

public interface KidManagingUseCase {
    AddKidResp addMyKid(Long userId, AddKidReq req);
    GetKidsProfilesResp getMyKidsProfiles(Long userId);
    GetKidsDetailResp getKidsDetail(Long kidId);
    UpdateKidsPersonalityResp updateKidsPersonality(Long kidId, UpdateKidPersonalityReq req);
}
