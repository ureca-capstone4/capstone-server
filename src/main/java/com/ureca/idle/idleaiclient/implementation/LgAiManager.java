package com.ureca.idle.idleaiclient.implementation;

import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiReq;
import com.ureca.idle.idleaiclient.business.dto.AddBookMbtiResp;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LgAiManager implements AiClientManager {

    private final RestTemplate restTemplate;

    @Value("${idle.ai_server.ip}")
    private String ip;

    @Override
    public AddBookMbtiResp createBookMbti(AddBookMbtiReq req) {
        //header & body 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("user_input", req.summary());

        //요청 송신
        String apiUrl = "http://" + ip + ":8000/chat";
        String response = restTemplate.postForObject(apiUrl, requestBody, String.class);

        //응답 처리
        try{
            //전체 JSON에서 response라는 필드 추출
            JSONObject jsonResponseWrapper = new JSONObject(response);
            String jsonResponseString = jsonResponseWrapper.getString("response");

            //추출한 문자열을 다시 JSON으로 파싱
            JSONObject jsonResponse = new JSONObject(jsonResponseString);

            AddBookMbtiResp resp = new AddBookMbtiResp(
                    jsonResponse.getInt("ei"),
                    jsonResponse.getInt("sn"),
                    jsonResponse.getInt("tf"),
                    jsonResponse.getInt("jp")
            );
            return resp;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
