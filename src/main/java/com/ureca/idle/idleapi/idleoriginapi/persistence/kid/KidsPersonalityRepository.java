package com.ureca.idle.idleapi.idleoriginapi.persistence.kid;


import com.ureca.idle.idlejpa.kidspersonality.KidsPersonality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface KidsPersonalityRepository extends JpaRepository<KidsPersonality, Long> {

}
