package ureca.idlebatch.kidspersonalityhistory.writer;

import com.ureca.idle.batch.kidspersonalityhistory.KidsPersonalityHistoryBatchManager;
import com.ureca.idle.batch.kidspersonalityhistory.dto.ChangedKidsPersonalityHistoryResp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveKidsPersonalityInHistoryWriter implements ItemWriter<ChangedKidsPersonalityHistoryResp> {

    @PersistenceContext
    private EntityManager entityManager;
    private final KidsPersonalityHistoryBatchManager kidsPersonalityHistoryBatchManager;

    @Override
    public void write(Chunk<? extends ChangedKidsPersonalityHistoryResp> chunk) {

        String sql = "INSERT INTO kids_personality_change_history " +
                "(created_at, ei, jp, kids_id, mbti, sn, tf, updated_at) VALUES ";
        StringBuilder values = new StringBuilder();

        List<? extends ChangedKidsPersonalityHistoryResp> kidsPersonalityChangeHistoryRespList = chunk.getItems();
        for (ChangedKidsPersonalityHistoryResp resp : kidsPersonalityChangeHistoryRespList) {
            kidsPersonalityHistoryBatchManager.saveKidsPersonalityHistory(resp, values);
        }

        if (values.length() > 0) {
            sql += values.substring(0, values.length() - 2) + ";"; // 마지막 두 문자(쉼표와 공백) 제거
            entityManager.createNativeQuery(sql).executeUpdate();
        }

        for (ChangedKidsPersonalityHistoryResp resp : kidsPersonalityChangeHistoryRespList) {
            log.info("자녀의 성향이 히스토리에 저장되었습니다.: " + resp.kidsId());
        }
    }
}
