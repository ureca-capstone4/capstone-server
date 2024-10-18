package com.ureca.idle.idleapi.idleoriginapi.persistence.kid;

import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.user.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KidRepository extends JpaRepository<Kid, Long> {
    boolean existsByUserAndName(User user, String name);

    List<Kid> getKidsByUser(User user);

    @Query("SELECT k FROM Kid k JOIN FETCH k.personality WHERE k.id = :id")
    Optional<Kid> findKidWithPersonalityById(@Param("id") Long id);
}
