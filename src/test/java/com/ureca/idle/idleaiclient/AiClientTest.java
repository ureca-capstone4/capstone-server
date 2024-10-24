package com.ureca.idle.idleaiclient;

import com.ureca.idle.idleaiclient.business.AiClientManagingUseCase;
import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiResp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiClientTest {
    @Autowired
    private AiClientManagingUseCase aiService;

    @Test
    void LGAI_connection(){
        AddBookMbtiReq addBookMbtiReq = new AddBookMbtiReq(
                "none",
                "옛날에 심술궂고 고집 센 부자가 살았어. 성이 옹가라 사람들은 부자를 옹고집이라 불렀지. 옹고집은 인색하기 짝이 없어서 이 집에 동냥 온 스님들은 매만 맞고 쫓겨나기 일쑤였어. 하루는 한 스님이 동냥하러 왔다가 옹고집한테 발로 채이고 쫓겨나고 말았어. 스님은 짚으로 허수아비를 만들어 담장 안으로 던져놓고는 어디론가 사라졌어. 이튿날 옹고집이 마실을 나갔다 와보니 사랑방에 자기랑 똑같이 생긴 놈이 앉아있는게 아니겠어?",
                "none");
        AddBookMbtiResp addBookMbtiResp = aiService.createBookMbti(addBookMbtiReq);
        System.out.println(addBookMbtiResp);
        Assertions.assertNotNull(addBookMbtiResp);
    }
}
