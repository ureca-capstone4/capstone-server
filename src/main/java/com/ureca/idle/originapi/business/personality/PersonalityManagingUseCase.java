package com.ureca.idle.originapi.business.personality;

import com.ureca.idle.originapi.business.personality.dto.GetKidsPersonalityHistoryResp;
import com.ureca.idle.originapi.business.personality.dto.GetTestQuestionsResp;
import com.ureca.idle.originapi.business.personality.dto.RemoveKidPersonalityResp;

public interface PersonalityManagingUseCase {

    // 2. 성향 테스트 질문지들 Get 요청
    GetTestQuestionsResp getPersonalityTestQuestions();

    // 3. 성향 삭제 요청
    RemoveKidPersonalityResp removePersonality(Long userId, Long kidId);

    // 4. 성향 히스토리 조회
    GetKidsPersonalityHistoryResp getKidsPersonalityHistory(Long kidId);



    

}
