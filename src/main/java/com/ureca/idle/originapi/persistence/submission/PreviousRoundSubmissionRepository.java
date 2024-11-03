package com.ureca.idle.originapi.persistence.submission;

import com.ureca.idle.jpa.submission.PreviousRoundSubmission;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PreviousRoundSubmissionRepository extends JpaRepository<PreviousRoundSubmission, Long> {
    @Query("SELECT p FROM PreviousRoundSubmission p WHERE timeStamp >= :startTime and timeStamp < :endTime ")
    List<PreviousRoundSubmission> findPreviousSubmissionResult(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
