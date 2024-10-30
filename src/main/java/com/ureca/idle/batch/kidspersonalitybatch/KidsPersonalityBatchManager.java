package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.batch.dto.KidsPersonalityChangeHistoryResp;
import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Slf4j
public class KidsPersonalityBatchManager {

    private final KidRepository kidRepository;

    @Transactional(readOnly = true)
    public KidsPersonalityChangeHistoryResp findKidWithPersonality(Long id) {
        Kid kid = kidRepository.findTestedPersonalityKidById(id);

        if (kid == null) {
            log.info("자녀가 존재하지 않습니다.");
        }

        KidsPersonality kidsPersonality = kidRepository.findKidPersonalityByKidId(id);

        if (kidsPersonality == null) {
            log.info("자녀의 성향을 찾을 수 없습니다.");
        }

        return new KidsPersonalityChangeHistoryResp(
                kid.getId(),
                kidsPersonality.getEi(),
                kidsPersonality.getSn(),
                kidsPersonality.getTf(),
                kidsPersonality.getJp(),
                kidsPersonality.getMbti());
    }

    @Transactional
    public void saveKidsPersonalityHistory(KidsPersonalityChangeHistoryResp resp, StringBuilder values) {
//        KidsPersonalityChangeHistory kidsPersonalityChangeHistory = KidsPersonalityChangeHistory.builder()
//                .kidsId(resp.kidsId())
//                .ei(resp.ei())
//                .sn(resp.sn())
//                .tf(resp.tf())
//                .jp(resp.jp())
//                .mbti(resp.mbti())
//                .build();
//        kidsPersonalityChangeHistoryRepository.save(kidsPersonalityChangeHistory);

        values.append("(")
                .append("NOW(), ")
                .append("'").append(resp.ei()).append("', ")
                .append("'").append(resp.jp()).append("', ")
                .append(resp.kidsId()).append(", ")
                .append("'").append(resp.mbti()).append("', ")
                .append("'").append(resp.sn()).append("', ")
                .append("'").append(resp.tf()).append("', ")
                .append("NOW()), ");
    }
}
