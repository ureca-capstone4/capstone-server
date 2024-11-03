package ureca.idleoriginapi.persistence.kid;


import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KidsPersonalityRepository extends JpaRepository<KidsPersonality, Long> {
}
