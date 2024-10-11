package com.ureca.idle.domain.dummy.manager;

import com.ureca.idle.domain.dummy.entity.Dummy;
import com.ureca.idle.domain.dummy.persistence.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DummyManager {

    private final DummyRepository dummyRepository;

    public Dummy getDummy(Long id) {
        // validation or something
        return dummyRepository.findById(id)
                .orElseThrow();
    }
}
