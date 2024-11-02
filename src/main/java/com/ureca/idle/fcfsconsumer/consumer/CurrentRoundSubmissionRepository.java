package com.ureca.idle.fcfsconsumer.consumer;

import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentRoundSubmissionRepository extends JpaRepository<CurrentRoundSubmission, Long> {

}
