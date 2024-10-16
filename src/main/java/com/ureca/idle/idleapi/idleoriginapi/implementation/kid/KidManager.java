package com.ureca.idle.idleapi.idleoriginapi.implementation.kid;

import com.ureca.idle.idleapi.idleoriginapi.persistence.kid.KidRepository;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class KidManager {

    private final KidRepository repository;

    public Kid registerKid(User user, String name, LocalDate birthDate) {
        Kid newKid = Kid.builder()
                .user(user)
                .name(name)
                .birthDate(birthDate)
                .build();
        return repository.save(newKid);
    }

    public List<Kid> getKidsByUser(User user) {
        return repository.getKidsByUser(user);
    }

    public void checkExitsKidByUserAndName(User user, String name) {
        if(repository.existsByUserAndName(user, name)) {
            throw new RuntimeException("이미 존재하는 이름의 KID 입니다.");
        }
    }
}
