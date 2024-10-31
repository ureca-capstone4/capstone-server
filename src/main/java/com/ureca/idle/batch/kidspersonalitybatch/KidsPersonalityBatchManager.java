package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.batch.dto.KidsPersonalityChangeHistoryResp;
import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class KidsPersonalityBatchManager {

    private final KidRepository kidRepository;

    @Transactional(noRollbackFor = KidsPersonalityBatchException.class)
    public KidsPersonalityChangeHistoryResp findKidWithPersonality(Long id) {

        Kid kid = kidRepository.findTestedPersonalityKidById(id)
                .orElseThrow(() -> new KidsPersonalityBatchException(KidsPersonalityBatchExceptionType.KID_NOT_FOUND_EXCEPTION));

        return new KidsPersonalityChangeHistoryResp(
                kid.getId(),
                kid.getPersonality().getEi(),
                kid.getPersonality().getSn(),
                kid.getPersonality().getTf(),
                kid.getPersonality().getJp(),
                kid.getPersonality().getMbti());
    }

    @Transactional()
    public void saveKidsPersonalityHistory(KidsPersonalityChangeHistoryResp resp, StringBuilder values) {
        try {
            values.append("(")
                    .append("NOW(), ")
                    .append("'").append(resp.ei()).append("', ")
                    .append("'").append(resp.jp()).append("', ")
                    .append(resp.kidsId()).append(", ")
                    .append("'").append(resp.mbti()).append("', ")
                    .append("'").append(resp.sn()).append("', ")
                    .append("'").append(resp.tf()).append("', ")
                    .append("NOW()), ");
        } catch (Exception e) {
            throw new KidsPersonalityBatchException(
                    KidsPersonalityBatchExceptionType.KIDS_PERSONALITY_HISTORY_NOT_SAVE_EXCEPTION_TYPE);
        }
    }
}