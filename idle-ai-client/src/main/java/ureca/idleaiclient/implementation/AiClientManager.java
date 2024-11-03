package ureca.idleaiclient.implementation;


import ureca.idleaiclient.business.dto.AddBookMbtiReq;
import ureca.idleaiclient.business.dto.AddBookMbtiResp;


public interface AiClientManager {
    AddBookMbtiResp createBookMbti(AddBookMbtiReq req);
}
