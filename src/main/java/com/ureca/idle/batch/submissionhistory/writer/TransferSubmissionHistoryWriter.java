package com.ureca.idle.batch.submissionhistory.writer;

import com.ureca.idle.batch.submissionhistory.SubmissionHistoryBatchManager;
import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransferSubmissionHistoryWriter implements ItemWriter<CurrentRoundSubmission> {

    @PersistenceContext
    private EntityManager entityManager;
    private final SubmissionHistoryBatchManager submissionHistoryBatchManager;

    @Override
    public void write(Chunk<? extends CurrentRoundSubmission> chunk) {

        String sql = "INSERT INTO previous_round_submission " +
                "(user_id, name, phone_num) VALUES ";
        StringBuilder values = new StringBuilder();

        List<? extends CurrentRoundSubmission> currentRoundSubmissionList = chunk.getItems();
        for (CurrentRoundSubmission currentRoundSubmission : currentRoundSubmissionList) {
            submissionHistoryBatchManager.savePreviousRoundSubmissionHistory(currentRoundSubmission, values);
        }

        if (values.length() > 0) {
            sql += values.substring(0, values.length() - 2) + ";"; // 마지막 두 문자(쉼표와 공백) 제거
            entityManager.createNativeQuery(sql).executeUpdate();
        }

        for (CurrentRoundSubmission currentRoundSubmission : currentRoundSubmissionList) {
            log.info("성공적으로 이전 차수 응모 테이블에 저장 완료되었습니다" + currentRoundSubmission.getName());
        }
    }

// BulkInsert와 그냥 인서트 속도 테스트를 위한 벌크 없이 바로 인서트 하는 코드
//    @Override
//    public void write(Chunk<? extends CurrentRoundSubmission> chunk) {
//        List<? extends CurrentRoundSubmission> currentRoundSubmissionList = chunk.getItems();
//
//        for (CurrentRoundSubmission currentRoundSubmission : currentRoundSubmissionList) {
//            try {
//                // 빌더 패턴을 사용하여 PreviousRoundSubmission 객체 생성
//                PreviousRoundSubmission previousRoundSubmission = PreviousRoundSubmission.builder()
//                        .userId(currentRoundSubmission.getUserId())
//                        .name(currentRoundSubmission.getName())
//                        .phoneNum(currentRoundSubmission.getPhoneNum())
//                        // 필요한 다른 필드 추가
//                        .build();
//
//                // 새로운 엔티티로 persist
//                entityManager.persist(previousRoundSubmission);
//                log.info("새로운 이전 차수 응모 테이블에 저장 완료되었습니다: " + previousRoundSubmission.getName());
//            } catch (Exception e) {
//                log.error("저장 중 오류 발생: " + e.getMessage(), e);
//            }
//        }
//    }
}