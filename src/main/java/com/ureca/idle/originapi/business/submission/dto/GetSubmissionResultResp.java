package com.ureca.idle.originapi.business.submission.dto;

import java.time.LocalDateTime;

public record GetSubmissionResultResp(Long id, LocalDateTime timeStamp, Long userId, String name, String phoneNum) {
}
