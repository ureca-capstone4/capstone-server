package com.ureca.idle.idleapi.idleoriginapi.business.preference;

public interface PreferenceManagingUseCase {

    void processLike(Long bookId, Long kidId);
    void processDislike(Long bookId, Long kidId);
}
