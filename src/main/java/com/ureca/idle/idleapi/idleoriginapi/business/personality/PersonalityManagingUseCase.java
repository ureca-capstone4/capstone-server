package com.ureca.idle.idleapi.idleoriginapi.business.personality;

import com.ureca.idle.idleapi.idleoriginapi.business.kidsPersonalityChangeHistory.dto.GetKidsPersonalityChangeHistoryResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.*;

public interface PersonalityManagingUseCase {

    // 2. 성향 테스트 질문지들 Get 요청
    GetTestQuestionsResp getPersonalityTestQuestions();

    // 3. 성향 삭제 요청
    RemoveKidPersonalityResp removePersonality(Long userId, Long kidId);

    // 4. 성향 히스토리 조회
    GetKidsPersonalityChangeHistoryResp getKidsPersonalityHistory(Long kidId);



    

}
