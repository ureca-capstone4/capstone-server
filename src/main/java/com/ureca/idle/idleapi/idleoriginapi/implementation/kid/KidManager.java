package com.ureca.idle.idleapi.idleoriginapi.implementation.kid;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.KidNotFoundException;
import com.ureca.idle.idleapi.idleoriginapi.persistence.kid.KidRepository;
import com.ureca.idle.idlejpa.kid.Gender;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.user.User;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KidManager {

    private final KidRepository repository;

    public Kid registerKid(User user, String name, String gender, LocalDate birthDate) {
        Kid newKid =
                Kid.builder()
                        .user(user)
                        .name(name)
                        .gender(Gender.from(gender))
                        .birthDate(birthDate)
                        .build();
        return repository.save(newKid);
    }

    public List<Kid> getKidsByUser(User user) {
        return repository.getKidsByUser(user);
    }

    public Kid getKidWithPersonality(Long id) {
        return repository
                .findKidWithPersonalityById(id)
                .orElseThrow(() -> new KidNotFoundException("해당 KID 를 찾을 수 없습니다."));
    }

    public void checkDuplicatedKidName(User user, String name) {
        if (repository.existsByUserAndName(user, name)) {
            throw new RuntimeException("이미 존재하는 이름의 KID 입니다.");
        }
    }
}
