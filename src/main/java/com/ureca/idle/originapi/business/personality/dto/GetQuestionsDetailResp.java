package com.ureca.idle.originapi.business.personality.dto;

import com.ureca.idle.jpa.question.MBTIType;

public record GetQuestionsDetailResp(Long id, String question, String answer1, String answer2, int value, MBTIType type) {

}
