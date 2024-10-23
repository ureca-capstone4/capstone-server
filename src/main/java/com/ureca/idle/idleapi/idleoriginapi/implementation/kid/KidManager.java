package com.ureca.idle.idleapi.idleoriginapi.implementation.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.UpdateKidPersonalityReq;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.kid.KidException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.kid.KidExceptionType;
import com.ureca.idle.idleapi.idleoriginapi.persistence.kid.KidRepository;
import com.ureca.idle.idleapi.idleoriginapi.persistence.kidPersonality.KidsPersonalityRepository;
import com.ureca.idle.idlejpa.kid.Gender;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.kidspersonality.KidsPersonality;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;



@Component
@RequiredArgsConstructor
public class KidManager {

    private final KidRepository repository;
    private final KidsPersonalityRepository kidsPersonalityRepository;


    public Kid registerKid(User user, String name, String gender, LocalDate birthDate) {
        Kid newKid = Kid.builder()
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
        return repository.findKidWithPersonalityById(id)
                .orElseThrow(() -> new KidException(KidExceptionType.NOT_FOUND_EXCEPTION));
    }

    public Kid getId(Long id) {
        return repository.getKidById(id)
                .orElseThrow(() -> new KidException(KidExceptionType.NOT_FOUND_EXCEPTION));
    }

    public void checkDuplicatedKidName(User user, String name) {
        if(repository.existsByUserAndName(user, name)) {
            throw new KidException(KidExceptionType.ALREADY_EXITS_NAME);
        }
    }

    // 아이의 personality에 MBTI 결과를 넣어주는 메소드
    public void updateKidPersonality(Long kidId, UpdateKidPersonalityReq req) {
        KidsPersonality kidPersonality = repository.findKidWithPersonalityById(kidId)
                .orElseThrow(() -> new KidException(KidExceptionType.NOT_FOUND_EXCEPTION)).getPersonality();

        kidPersonality.updateKidsPersonality(req.ei(), req.sn(), req.tf(), req.jp(), req.mbti(), true);
    }

}
