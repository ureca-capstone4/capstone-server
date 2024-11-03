package com.ureca.idle.fcfsconsumer.consumer;


import java.io.Serializable;
import java.time.LocalDateTime;


// TODO 헥사고날 아키텍쳐 변경 시 domain 에 집어넣기
public record Submission(LocalDateTime timeStamp, String userId, String name, String phoneNum) implements Serializable {
}
