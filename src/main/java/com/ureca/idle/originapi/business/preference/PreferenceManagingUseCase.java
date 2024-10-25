package com.ureca.idle.originapi.business.preference;

public interface PreferenceManagingUseCase {

    void processLike(Long bookId, Long kidId);
    void processDislike(Long bookId, Long kidId);
}
