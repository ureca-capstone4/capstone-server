package com.ureca.idle.idleapi.idleoriginapi.business.personality;

import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.*;

public interface PersonalityManagingUseCase {
    // 1. 성향 검사 진행 결과 발송
    // 프론트에서 테스트 진행 -> 결과를 서버로 전송 -> 아이 성향에 반영
    AddKidPersonalityResp addMyKidPersonality(Long kidId, AddKidPersonalityReq req);

    // 2. 성향 테스트 질문지들 Get 요청
    GetTestQuestionsResp getPersonalityTestQuestions();

    // 3. 성향 삭제 요청
    RemoveKidPersonalityResp removePersonality(Long userId, Long kidId);

    // 4. 성향 히스토리 조회
    GetKidsPersonalityHistoryResp getKidsPersonalityHistory(Long kidId);



    

}
