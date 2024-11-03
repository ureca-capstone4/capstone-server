package ureca.idleoriginapi.business.bookPreference;

public interface BookPreferenceManagingUseCase {

    void processLike(Long bookId, Long kidId);
    void processDislike(Long bookId, Long kidId);
}
