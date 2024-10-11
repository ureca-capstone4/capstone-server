package com.ureca.idle.domain.dummy.persistence;

import com.ureca.idle.domain.dummy.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<Dummy, Long> {
}
