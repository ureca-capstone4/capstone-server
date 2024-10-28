package com.ureca.idle.originapi.implementation.kid;



import com.ureca.idle.jpa.bookscharacteristic.BooksCharacteristic;
import com.ureca.idle.jpa.kid.Gender;
import com.ureca.idle.jpa.kid.Kid;
import com.ureca.idle.jpa.user.User;
import com.ureca.idle.jpa.kidspersonality.KidsPersonality;
import com.ureca.idle.jpa.kidspersonality.KidsPersonalityDeleteHistory;
import com.ureca.idle.originapi.business.kid.dto.AddKidReq;
import com.ureca.idle.originapi.business.kid.dto.UpdateKidPersonalityReq;
import com.ureca.idle.originapi.implementation.util.MBTI;
import com.ureca.idle.originapi.implementation.util.MBTIUtil;
import com.ureca.idle.originapi.persistence.book.BookRepository;
import com.ureca.idle.originapi.persistence.book.BooksCharacteristicRepository;
import com.ureca.idle.originapi.persistence.kid.KidRepository;
import com.ureca.idle.originapi.persistence.kid.KidsPersonalityDeleteHistoryRepository;
import com.ureca.idle.originapi.persistence.kid.KidsPersonalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class KidManager {

    private final KidRepository repository;
    private final KidsPersonalityRepository kidsPersonalityRepository;
    private final MBTIUtil mbtiUtil;
    private final KidsPersonalityDeleteHistoryRepository kidsPersonalityDeleteHistory;
    private final BooksCharacteristicRepository booksCharacteristicRepository;
    private final KidRepository kidRepository;

    private static final double MBTI_WEIGHT = 0.1;

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

    public void checkDuplicatedKidName(User user, String name) {
        if(repository.existsByUserAndName(user, name)) {
            throw new KidException(KidExceptionType.ALREADY_EXITS_NAME);
        }
    }

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

    public KidsPersonality generateRandomKidsPersonality(Long kidId) {
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

    public KidsPersonalityDeleteHistory putKidPersonalityIntoDeleteHistory(Long kidId, KidsPersonality kidsPersonality) {
        KidsPersonalityDeleteHistory newDeletePersonality = KidsPersonalityDeleteHistory.builder()
                .kidsId(kidId)
                .ei(kidsPersonality.getEi())
                .sn(kidsPersonality.getSn())
                .tf(kidsPersonality.getTf())
                .jp(kidsPersonality.getJp())
                .mbti(kidsPersonality.getMbti())
                .build();
        return kidsPersonalityDeleteHistory.save(newDeletePersonality);
    }

    public void updateRandomKidPersonality(Long kidId) {
        KidsPersonality kidPersonality = repository.findKidWithPersonalityById(kidId)
                .orElseThrow(() -> new KidException(KidExceptionType.NOT_FOUND_EXCEPTION)).getPersonality();
        MBTI randomMBTI = mbtiUtil.generateRandomMBTI();
        kidPersonality.updateKidsPersonality(randomMBTI.ei(), randomMBTI.sn(), randomMBTI.tf(), randomMBTI.jp(), randomMBTI.mbti(), false);
    }

    public void increasePersonality(Long kidId, Long bookId){
        KidsPersonality kidsPersonality = kidRepository.findKidPersonalityByKidId(kidId);
        BooksCharacteristic booksCharacteristic = booksCharacteristicRepository.findBooksCharacteristicByBookId(bookId);
        int ei = (int) (kidsPersonality.getEi() + booksCharacteristic.getEi() * MBTI_WEIGHT);
        int sn = (int) (kidsPersonality.getSn() + booksCharacteristic.getSn() * MBTI_WEIGHT);
        int tf = (int) (kidsPersonality.getTf() + booksCharacteristic.getTf() * MBTI_WEIGHT);
        int jp = (int) (kidsPersonality.getJp() + booksCharacteristic.getJp() * MBTI_WEIGHT);
        MBTI kidMbti = personalityValidation(ei, sn, tf, jp);
        kidsPersonality.updateKidsPersonality(kidMbti.ei(), kidMbti.sn(), kidMbti.tf(), kidMbti.jp(), kidMbti.mbti(), kidsPersonality.isTested());
    }

    public void decreasePersonality(Long kidId, Long bookId){
        KidsPersonality kidsPersonality = kidRepository.findKidPersonalityByKidId(kidId);
        BooksCharacteristic booksCharacteristic = booksCharacteristicRepository.findBooksCharacteristicByBookId(bookId);
        int ei = (int) (kidsPersonality.getEi() - booksCharacteristic.getEi() * MBTI_WEIGHT);
        int sn = (int) (kidsPersonality.getSn() - booksCharacteristic.getSn() * MBTI_WEIGHT);
        int tf = (int) (kidsPersonality.getTf() - booksCharacteristic.getTf() * MBTI_WEIGHT);
        int jp = (int) (kidsPersonality.getJp() - booksCharacteristic.getJp() * MBTI_WEIGHT);
        MBTI kidMbti = personalityValidation(ei, sn, tf, jp);
        kidsPersonality.updateKidsPersonality(kidMbti.ei(), kidMbti.sn(), kidMbti.tf(), kidMbti.jp(), kidMbti.mbti(), kidsPersonality.isTested());
    }

    public MBTI personalityValidation(int ei, int sn, int tf, int jp){
        if(ei < 1) ei = 1; if(sn < 1) sn = 1; if(tf < 1) tf = 1; if(jp < 1) jp = 1;
        if(ei > 100) ei = 100; if(sn > 100) sn = 100; if(tf > 100) tf = 100; if(jp > 100) jp = 100;
        MBTIUtil mbtiUtil = new MBTIUtil();
        return new MBTI(ei, sn, tf, jp, mbtiUtil.getMBTIByElement(ei, sn, tf, jp));
    }
}
