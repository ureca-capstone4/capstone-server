package ureca.idlebatch.kidspersonalityhistory.processor;

import com.ureca.idle.batch.kidspersonalityhistory.KidsPersonalityHistoryBatchManager;
import com.ureca.idle.batch.kidspersonalityhistory.dto.ChangedKidsPersonalityHistoryResp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KidsPersonalityProcessor implements ItemProcessor<Long, ChangedKidsPersonalityHistoryResp> {

    private final KidsPersonalityHistoryBatchManager kidsPersonalityHistoryBatchManager;

    @Override
    public ChangedKidsPersonalityHistoryResp process(Long kidsPersonalityId) throws Exception {
        try {
            ChangedKidsPersonalityHistoryResp resp = kidsPersonalityHistoryBatchManager.findKidWithPersonality(kidsPersonalityId);
            return resp;
        } catch (Exception e) {
            log.info("현재 자녀의 성향 검사가 이루어지지 않았습니다.");
            return null;
        }
    }
}

