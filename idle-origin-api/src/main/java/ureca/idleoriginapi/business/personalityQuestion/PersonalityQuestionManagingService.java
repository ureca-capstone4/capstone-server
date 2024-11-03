package ureca.idleoriginapi.business.personalityQuestion;


import com.ureca.idle.jpa.personalityquestion.PersonalityQuestion;
import com.ureca.idle.originapi.business.personalityQuestion.dto.GetPersonalityQuestionsResp;
import com.ureca.idle.originapi.implementation.mapper.PersonalityQuestionDtoMapper;
import com.ureca.idle.originapi.implementation.personalityQuestion.PersonalityQuestionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonalityQuestionManagingService implements PersonalityQuestionManagingUseCase {

    private final PersonalityQuestionManager personalityQuestionManager;
    private final PersonalityQuestionDtoMapper personalityQuestionDtoMapper;

    @Override
    @Transactional(readOnly = true)
    public GetPersonalityQuestionsResp getPersonalityQuestions() {
        List<PersonalityQuestion> questionList = personalityQuestionManager.getPersonalityQuestions();
        return personalityQuestionDtoMapper.toGetPersonalityQuestionList(questionList);
    }
}
