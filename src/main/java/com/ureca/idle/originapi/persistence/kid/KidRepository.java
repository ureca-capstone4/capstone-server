package com.ureca.idle.originapi.persistence.kid;

import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import com.ureca.idle.jpa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KidRepository extends JpaRepository<Kid, Long> {
    boolean existsByUserAndName(User user, String name);
    List<Kid> getKidsByUser(User user);
    @Query("SELECT k FROM Kid k JOIN FETCH k.personality WHERE k.id = :id")
    Optional<Kid> findKidWithPersonalityById(@Param("id") Long id);
    Optional<Kid> getKidById(Long id);
    @Query("SELECT k.personality FROM Kid k WHERE k.id = :kidId")
    KidsPersonality findKidPersonalityByKidId(@Param("kidId") Long kidId);
    @Query("SELECT k FROM Kid k JOIN FETCH k.personality WHERE k.personality.id = :id AND k.personality.isTested = true")
    Optional<Kid> findTestedPersonalityKidById(@Param("id") Long id);
}