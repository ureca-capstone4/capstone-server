package com.ureca.idle.originapi.business.bookPreference;


import com.ureca.idle.originapi.implementation.bookPreference.BookPreferenceManager;
import com.ureca.idle.jpa.bookpreference.BookPreference;
import com.ureca.idle.jpa.bookpreference.Hobulho;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBookPreferenceManagingService implements BookPreferenceManagingUseCase {
    private final BookPreferenceManager bookPreferenceManager;

    @Override
    public void processLike(Long bookId, Long kidId) {
        BookPreference bookPreference = bookPreferenceManager.getPreference(bookId, kidId);
        if(bookPreferenceManager.checkBookPreferenceExistence(bookPreference)) {
            bookPreferenceManager.like(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.HO){
            bookPreferenceManager.cancelHobulho(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.BULHO){
            bookPreferenceManager.cancelHobulho(bookId, kidId);
            bookPreferenceManager.like(bookId, kidId);
        }
    }

    @Override
    public void processDislike(Long bookId, Long kidId) {
        BookPreference bookPreference = bookPreferenceManager.getPreference(bookId, kidId);
        if(bookPreferenceManager.checkBookPreferenceExistence(bookPreference)){
            bookPreferenceManager.dislike(bookId, kidId);
        } else if(bookPreference.getHobulho() == Hobulho.HO){
            bookPreferenceManager.cancelHobulho(bookId, kidId);
            bookPreferenceManager.dislike(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.BULHO){
            bookPreferenceManager.cancelHobulho(bookId, kidId);
        }
    }
}
