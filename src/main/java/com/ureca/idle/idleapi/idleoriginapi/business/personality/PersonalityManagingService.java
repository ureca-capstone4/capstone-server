package com.ureca.idle.idleapi.idleoriginapi.business.personality;


import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.*;
import com.ureca.idle.idleapi.idleoriginapi.implementation.mapper.PersonalityDtoMapper;
import com.ureca.idle.idleapi.idleoriginapi.implementation.personality.PersonalityManager;
import com.ureca.idle.idleapi.idleoriginapi.implementation.user.UserManager;
import com.ureca.idle.idlejpa.question.PersonalityQuestion;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalityManagingService implements PersonalityManagingUseCase{

    private final UserManager userManager;
    private final PersonalityManager personalityManager;
    private final PersonalityDtoMapper personalityDtoMapper;

    @Override
    public AddKidPersonalityResp addMyKidPersonality(Long kidId, AddKidPersonalityReq req) {
        // 사용자 getCurrentUserlogin 사용해서 현재 로그인한 사용자 가져오고
        // 테스트 결과를 kidId에 넣고
        // 흠.. 이걸 Kid 안에 넣어주는 거면, Kid dto Mapper에 해당 MBTI 결과를 넣는 메소드 만들어줘야할듯

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public GetTestQuestionsResp getPersonalityTestQuestions() {
        List<PersonalityQuestion> questionList = personalityManager.getPersonalityQuestions();
        return personalityDtoMapper.toGetPersonalityQuestions(questionList);
    }

    @Override
    public RemoveKidPersonalityResp removePersonality(Long userId, Long kidId) {

        return null;
    }

    @Override
    public GetKidsPersonalityHistoryResp getKidsPersonalityHistory(Long kidId) {

        return null;
    }
}
