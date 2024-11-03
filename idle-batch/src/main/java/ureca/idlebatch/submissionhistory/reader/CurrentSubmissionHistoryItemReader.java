package ureca.idlebatch.submissionhistory.reader;

import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CurrentSubmissionHistoryItemReader {

    private final EntityManagerFactory entityManagerFactory;

    public JpaPagingItemReader<CurrentRoundSubmission> currentSubmissionHistoryItemReader() {
        return new JpaPagingItemReaderBuilder<CurrentRoundSubmission>()
                .name("currentSubmissionHistoryItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT crs FROM CurrentRoundSubmission crs")
                .pageSize(50)
                .build();
    }
}