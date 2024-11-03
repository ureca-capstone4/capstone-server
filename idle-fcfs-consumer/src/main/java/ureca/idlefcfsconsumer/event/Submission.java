package ureca.idlefcfsconsumer.event;

import java.io.Serializable;


// TODO 헥사고날 아키텍쳐 변경 시 domain 에 집어넣기
public record Submission(String timeStamp, String userId, String name, String phoneNum) implements Serializable {
}
