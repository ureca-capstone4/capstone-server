package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.jpa.kid.Kid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveKidsItemProcessor implements ItemProcessor<Long, Kid> {

    private final KidsPersonalityBatchManager kidsPersonalityBatchManager;

    @Override
    public Kid process(Long kidsid) throws Exception {
        log.info("프로세서에서 처리 중...");
        Kid kid = kidsPersonalityBatchManager.findKidWithPersonality(kidsid);
        if (kid == null) {
            log.warn("Kid not found for ID: " + kidsid);
            return null; //TODO 적절한 예외처리 추가
        }
        return kid;
    }
}

