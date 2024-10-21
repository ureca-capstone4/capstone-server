package com.ureca.idle.idleapi.idleoriginapi.business.personality;


import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.AddKidPersonalityResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.GetKidsPersonalityHistoryResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.GetTestQuestionsResp;
import com.ureca.idle.idleapi.idleoriginapi.business.personality.dto.RemoveKidPersonalityResp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalityManagingService implements PersonalityManagingUseCase{



    @Override
    public AddKidPersonalityResp addMyKidPersonality() {
        return null;
    }

    @Override
    public GetTestQuestionsResp getPersonalityTestQuestions() {
        return null;
    }

    @Override
    public RemoveKidPersonalityResp removePersonality() {
        return null;
    }

    @Override
    public GetKidsPersonalityHistoryResp getKidsPersonalityHistory() {
        return null;
    }
}
