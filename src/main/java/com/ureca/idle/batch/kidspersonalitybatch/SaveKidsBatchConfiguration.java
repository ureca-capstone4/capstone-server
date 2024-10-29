package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.batch.dto.KidsResp;
import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SaveKidsBatchConfiguration {

    private final KidsPersonalityBatchManager kidsPersonalityBatchManager;

    @Bean
    public Job saveKidsPersonalityJob(JobRepository jobRepository, Step saveKidsPersonalityStep) {
        return new JobBuilder("saveKidsPersonalityJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(saveKidsPersonalityStep)
                .build();
    }

    @Bean
    public Step saveKidsPersonalityStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveKidsPersonalityStep", jobRepository)
                .<Kid, KidsResp>chunk(1, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public ItemReader<Kid> itemReader() {
        return new ItemReader<Kid>() {
            private List<Kid> kidlist = kidsPersonalityBatchManager.findAllKids();
            private int index = 0;

            @Override
            public Kid read() throws Exception {
                if (index < kidlist.size()) {
                    Kid kid = kidlist.get(index++);
                    Optional<Kid> kidWithPersonality = kidsPersonalityBatchManager.findKidWithPersonality(kid.getId());
                    if (kidWithPersonality.isPresent()) {
                        log.info("Kid with personality: " + kidWithPersonality.get());
                        if(kidWithPersonality.get().getPersonality().isTested()){
                            return kidWithPersonality.get();
                        }
                    }
                }
                return null;
            }
        };
    }

    @Bean
    public ItemProcessor<Kid, KidsResp> itemProcessor() {
        return kid -> new KidsResp(
                kid.getId(),
                kid.getPersonality().getEi(),
                kid.getPersonality().getSn(),
                kid.getPersonality().getTf(),
                kid.getPersonality().getJp(),
                kid.getPersonality().getMbti()
        );
    }

    @Bean
    public ItemWriter<KidsResp> itemWriter() {
        return items -> {
            for (KidsResp kidResp : items) {
                KidsPersonalityChangeHistory kidsPersonalityChangeHistory = KidsPersonalityChangeHistory.builder()
                        .kidsId(kidResp.kidId())
                        .ei(kidResp.ei())
                        .sn(kidResp.sn())
                        .tf(kidResp.tf())
                        .jp(kidResp.jp())
                        .mbti(kidResp.mbti())
                        .build();

                try {
                    kidsPersonalityBatchManager.saveKidsPersonalityHistory(kidsPersonalityChangeHistory);
                    log.info("Saved history: " + kidsPersonalityChangeHistory);
                } catch (Exception e) {
                    log.error("Error saving history: " + e.getMessage(), e);
                }
            }
        };
    }
}
