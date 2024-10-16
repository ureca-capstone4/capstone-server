package com.ureca.idle.idleapi.idleoriginapi.persistence.kid;

import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KidRepository extends JpaRepository<Kid, Long> {
    boolean existsByUserAndName(User user, String name);
    List<Kid> getKidsByUser(User user);
}
