package com.ureca.idle.batch.kidspersonalityhistory;

import com.ureca.idle.batch.kidspersonalityhistory.dto.ChangedKidsPersonalityHistoryResp;
import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class KidsPersonalityHistoryBatchManager {

    private final KidRepository kidRepository;

    @Transactional
    public ChangedKidsPersonalityHistoryResp findKidWithPersonality(Long id) {

        Kid kid = kidRepository.findTestedPersonalityKidById(id)
                .orElseThrow(() -> new KidsPersonalityHistoryBatchException(KidsPersonalityHistoryBatchExceptionType.KID_NOT_FOUND_EXCEPTION));

        return new ChangedKidsPersonalityHistoryResp(
                kid.getId(),
                kid.getPersonality().getEi(),
                kid.getPersonality().getSn(),
                kid.getPersonality().getTf(),
                kid.getPersonality().getJp(),
                kid.getPersonality().getMbti());
    }

    @Transactional
    public void saveKidsPersonalityHistory(ChangedKidsPersonalityHistoryResp resp, StringBuilder values) {
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
            throw new KidsPersonalityHistoryBatchException(
                    KidsPersonalityHistoryBatchExceptionType.KIDS_PERSONALITY_HISTORY_NOT_SAVE_EXCEPTION_TYPE);
        }
    }
}