package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.batch.dto.KidsPersonalityChangeHistoryResp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveKidsItemProcessor implements ItemProcessor<Long, KidsPersonalityChangeHistoryResp> {

    private final KidsPersonalityBatchManager kidsPersonalityBatchManager;

    @Override
    public KidsPersonalityChangeHistoryResp process(Long kidsId) throws Exception {
        try {
            KidsPersonalityChangeHistoryResp resp = kidsPersonalityBatchManager.findKidWithPersonality(kidsId);
            return resp;
        } catch (Exception e) {
            log.info("현재 자녀의 성향 검사가 이루어지지 않았습니다.");
            return null;
        }
    }
}

