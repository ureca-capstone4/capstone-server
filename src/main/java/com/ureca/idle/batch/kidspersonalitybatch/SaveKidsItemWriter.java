package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.jpa.kid.Kid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveKidsItemWriter implements ItemWriter<Kid> {

    private final KidsPersonalityBatchManager kidsPersonalityBatchManager;

    @Override
    public void write(Chunk<? extends Kid> chunk) throws Exception {
        List<? extends Kid> kidsList = chunk.getItems();
        for (Kid kid : kidsList) {
            kidsPersonalityBatchManager.saveKidsPersonalityHistory(kid);
            log.info("Saved history: " + kid.getId());
        }
    }
}
