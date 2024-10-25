package com.ureca.idle.originapi.business.preference;


import com.ureca.idle.originapi.implementation.preference.PreferenceManager;
import com.ureca.idle.jpa.bookpreference.BookPreference;
import com.ureca.idle.jpa.bookpreference.Hobulho;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceManagingService implements PreferenceManagingUseCase {
    private final PreferenceManager preferenceManager;

    @Override
    public void processLike(Long bookId, Long kidId) {
        BookPreference bookPreference = preferenceManager.getPreference(bookId, kidId);
        if(bookPreference == null){
            preferenceManager.like(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.HO){
            preferenceManager.cancelHobulho(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.BULHO){
            preferenceManager.cancelHobulho(bookId, kidId);
            preferenceManager.like(bookId, kidId);
        }
    }

    @Override
    public void processDislike(Long bookId, Long kidId) {
        BookPreference bookPreference = preferenceManager.getPreference(bookId, kidId);
        if(bookPreference == null){
            preferenceManager.dislike(bookId, kidId);
        } else if(bookPreference.getHobulho() == Hobulho.HO){
            preferenceManager.cancelHobulho(bookId, kidId);
            preferenceManager.dislike(bookId, kidId);
        } else if (bookPreference.getHobulho() == Hobulho.BULHO){
            preferenceManager.cancelHobulho(bookId, kidId);
        }
    }
}
