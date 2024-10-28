package com.ureca.idle.originapi.persistence.kid;

import com.ureca.idle.jpa.kidspersonality.KidsPersonalityChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KidsPersonalityChangeHistoryRepository extends JpaRepository<KidsPersonalityChangeHistory, Long> {
    // TODO: 월별로 가져오는 기능은 추후 구현
    List<KidsPersonalityChangeHistory> getKidsPersonalityChangeHistoriesById(Long kidId);
//    List<KidsPersonalityChangeHistory> getKidsPersonalityChangeHistoriesBy(Long kidId, Long month);

    @Modifying
    @Query("DELETE from KidsPersonalityChangeHistory k where k.kidsId = :kidId")
    void deleteAllByKidsId(@Param("kidId") Long kidId);
}
