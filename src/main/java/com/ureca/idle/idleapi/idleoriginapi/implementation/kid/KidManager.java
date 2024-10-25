package com.ureca.idle.idleapi.idleoriginapi.implementation.kid;

import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.AddKidReq;
import com.ureca.idle.idleapi.idleoriginapi.business.kid.dto.UpdateKidPersonalityReq;
import com.ureca.idle.idleapi.idleoriginapi.implementation.util.MBTI;
import com.ureca.idle.idleapi.idleoriginapi.implementation.util.MBTIUtil;
import com.ureca.idle.idleapi.idleoriginapi.persistence.kid.KidRepository;
import com.ureca.idle.idleapi.idleoriginapi.persistence.kid.KidsPersonalityRepository;
import com.ureca.idle.idlejpa.bookscharacteristic.BooksCharacteristic;
import com.ureca.idle.idlejpa.kid.Gender;
import com.ureca.idle.idlejpa.kid.Kid;
import com.ureca.idle.idlejpa.kidspersonality.KidsPersonality;
import com.ureca.idle.idlejpa.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class KidManager {

    private final KidRepository repository;
    private final KidsPersonalityRepository kidsPersonalityRepository;
    private final MBTIUtil mbtiUtil;

    public Kid registerKid(User user, AddKidReq req, KidsPersonality newKidsPersonality) {
        Kid newKid = Kid.builder()
                .user(user)
                .personality(newKidsPersonality)
                .name(req.name())
                .gender(Gender.from(req.gender()))
                .birthDate(req.birthDate())
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

    public Kid getKid(Long id) {
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

    public KidsPersonality generateRandomKidsPersonality() {
        MBTI randomMBTI = mbtiUtil.generateRandomMBTI();
        KidsPersonality randomKidsPersonality = KidsPersonality.builder()
                .ei(randomMBTI.ei())
                .sn(randomMBTI.sn())
                .tf(randomMBTI.tf())
                .jp(randomMBTI.jp())
                .mbti(randomMBTI.mbti())
                .build();
        return kidsPersonalityRepository.save(randomKidsPersonality);
    }

}
