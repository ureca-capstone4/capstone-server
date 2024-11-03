package ureca.idleaiclient.business;

import lombok.RequiredArgsConstructor;
import ureca.idleaiclient.business.dto.AddBookMbtiReq;
import ureca.idleaiclient.business.dto.AddBookMbtiResp;
import ureca.idleaiclient.implementation.AiClientManager;

@Service
@RequiredArgsConstructor
public class LgAiClientManagingService implements AiClientManagingUseCase {

    private final AiClientManager aiClientManager;

    @Override
    public AddBookMbtiResp createBookMbti(AddBookMbtiReq req) {
        return aiClientManager.createBookMbti(req);
    }
}
