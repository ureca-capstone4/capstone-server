package com.ureca.idle.idleapi.idleoriginapi.business.personality.dto;

import com.ureca.idle.idlejpa.question.MBTIType;

public record GetQuestionsDetailResp(Long id, String question, String answer1, String answer2, int value, MBTIType type) {

}
