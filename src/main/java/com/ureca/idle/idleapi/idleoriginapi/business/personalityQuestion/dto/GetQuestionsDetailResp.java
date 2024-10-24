package com.ureca.idle.idleapi.idleoriginapi.business.personalityQuestion.dto;

import com.ureca.idle.idlejpa.personalityquestion.MBTIType;

public record GetQuestionsDetailResp(Long id, String question, String answer1, String answer2, int value, MBTIType type) {

}
