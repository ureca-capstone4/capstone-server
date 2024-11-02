package com.ureca.idle.fcfsproducer.event;


import java.io.Serializable;
import java.time.LocalDateTime;


// TODO 헥사고날 아키텍쳐 변경 시 domain 에 집어넣기
public record Submission(String timeStamp, String userId, String name, String phoneNum) implements Serializable {
}
