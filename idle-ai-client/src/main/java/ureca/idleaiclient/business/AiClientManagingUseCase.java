package ureca.idleaiclient.business;


import ureca.idleaiclient.business.dto.AddBookMbtiReq;
import ureca.idleaiclient.business.dto.AddBookMbtiResp;

public interface AiClientManagingUseCase {
    AddBookMbtiResp createBookMbti(AddBookMbtiReq req);
}
