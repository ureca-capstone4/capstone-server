package com.ureca.idle.originapi.business.bookPreference;


import com.ureca.idle.originapi.implementation.bookPreference.BookPreferenceManager;
import com.ureca.idle.jpa.bookpreference.BookPreference;
import com.ureca.idle.jpa.bookpreference.Hobulho;
import com.ureca.idle.originapi.implementation.kid.KidManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookBookPreferenceManagingService implements BookPreferenceManagingUseCase {
    private final BookPreferenceManager bookPreferenceManager;
    private final KidManager kidManager;

    @Override
    @Transactional
    public void processLike(Long bookId, Long kidId) {
        BookPreference bookPreference = bookPreferenceManager.getPreference(bookId, kidId);
        if(!bookPreferenceManager.checkBookPreferenceExistence(bookPreference)) {
            bookPreferenceManager.like(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.HO){
            bookPreferenceManager.cancelLike(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.BULHO){
            bookPreferenceManager.cancelDislike(bookId, kidId);
            bookPreferenceManager.like(bookId, kidId);
            kidManager.increasePersonality(kidId, bookId);
        }
    }

    @Override
    @Transactional
    public void processDislike(Long bookId, Long kidId) {
        BookPreference bookPreference = bookPreferenceManager.getPreference(bookId, kidId);
        if(!bookPreferenceManager.checkBookPreferenceExistence(bookPreference)){
            bookPreferenceManager.dislike(bookId, kidId);
        } else if(bookPreference.getHobulho() == Hobulho.HO){
            bookPreferenceManager.cancelLike(bookId, kidId);
            bookPreferenceManager.dislike(bookId, kidId);
            kidManager.decreasePersonality(kidId, bookId);
        } else if (bookPreference.getHobulho() == Hobulho.BULHO){
            bookPreferenceManager.cancelDislike(bookId, kidId);
        }
    }
}
